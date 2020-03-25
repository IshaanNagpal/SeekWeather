package com.spdigital.seekweather.repository

import com.spdigital.seekweather.network.Resource
import com.spdigital.seekweather.network.ResourceError
import com.spdigital.seekweather.utility.AppUtility
import okhttp3.ResponseBody
import org.koin.core.KoinComponent
import org.koin.core.inject
import retrofit2.Converter
import retrofit2.Response
import retrofit2.Retrofit

open class BaseRepository(private val appUtility: AppUtility) : KoinComponent {

    private val retrofit: Retrofit by inject()

    suspend fun <T> safeApiCall(call: suspend () -> Response<T>): Resource<T> {

        return if(appUtility.isInternetAvailable()) {
            val response = call.invoke()

            if (response.isSuccessful) {
                Resource.success(response.body())
            } else {
                Resource.error(parseError(response.errorBody()))
            }
        } else {
            Resource.error(ResourceError())
        }
    }


    private fun parseError(responseErrorBody: ResponseBody?): ResourceError {

        val converter: Converter<ResponseBody, ResourceError> =
            retrofit.responseBodyConverter(ResourceError::class.java, arrayOfNulls<Annotation>(0))
        try {
            responseErrorBody?.let {
                return converter.convert(it) ?: ResourceError()
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return ResourceError()
    }
}