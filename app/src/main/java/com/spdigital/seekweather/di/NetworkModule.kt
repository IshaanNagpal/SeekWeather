package com.spdigital.seekweather.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.spdigital.seekweather.BuildConfig
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { provideRetrofit(get()) }
    factory { provideOkHttpClient() }
}


fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(BuildConfig.API_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(CoroutineCallAdapterFactory()).build()
}

fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient().newBuilder().build()
}
