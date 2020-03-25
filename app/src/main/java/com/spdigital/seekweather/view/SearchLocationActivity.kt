package com.spdigital.seekweather.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.sample.gitrepos.extensions.filterNull
import com.spdigital.seekweather.R
import com.spdigital.seekweather.databinding.ActivityMainBinding
import com.spdigital.seekweather.extensions.setCharacterLimitedQuery
import com.spdigital.seekweather.viewmodel.SearchLocationViewModelImpl
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchLocationActivity : BaseActivity() {

    private lateinit var genericAdapter: GenericAdapter<ListItemModel>
    private lateinit var mBinding: ActivityMainBinding
    private val searchLocationViewModelImpl: SearchLocationViewModelImpl by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        observeForViewModel()
        configureBinding()
        setSearchListener()
        configureRecyclerView()
        searchLocationViewModelImpl.getRecentlySearchedLocations()
    }

    private fun observeForViewModel() {
        searchLocationViewModelImpl.observeForLocationsList().observe(this, Observer {
            setDataOnList(it)
        })

        searchLocationViewModelImpl.observeForNavigator().observe(this, Observer {
            navigateToDetailActivity(it)
        })

        searchLocationViewModelImpl.observeForRetry().observe(this, Observer {
            if(it) {
                searchLocationViewModelImpl.getSearchedLocation(location_searchview.query.toString().filterNull())
            }
        })
    }

    private fun navigateToDetailActivity(location: String) {
        val intent = Intent(this, WeatherDetailActivity::class.java)
        intent.putExtra("CITY", location)
        startActivity(intent)
    }

    private fun configureBinding() {
        mBinding.viewModel = searchLocationViewModelImpl
        mBinding.lifecycleOwner = this
    }

    private fun setSearchListener() {
        location_searchview.setCharacterLimitedQuery(reset = {
            searchLocationViewModelImpl.getRecentlySearchedLocations()
        }, changeInText = {
            searchLocationViewModelImpl.getSearchedLocation(it)
        }, submitPressed = {
            searchLocationViewModelImpl.getSearchedLocation(it)
        })
    }

    private fun configureRecyclerView() {
        location_recyclerview.layoutManager = LinearLayoutManager(this)
        location_recyclerview.addItemDecoration(
            DividerItemDecoration(location_recyclerview.context, OrientationHelper.VERTICAL)
        )
    }

    private fun setDataOnList(gitReposModelList: List<ListItemModel>) {
        if (!::genericAdapter.isInitialized) {
            genericAdapter = GenericAdapter(gitReposModelList)
            location_recyclerview.adapter = genericAdapter
        } else {
            genericAdapter.updateItems(gitReposModelList)
        }
    }
}
