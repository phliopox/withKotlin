package com.prac.kotlinself.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.prac.kotlinself.model.Banner
import com.prac.kotlinself.repository.HomeAssetDataSource

class HomeViewModel(private val repository: HomeAssetDataSource) : ViewModel() {
    private val _banners = MutableLiveData<List<Banner>>()
    val banners : LiveData<List<Banner>> = _banners
    init{
        loadHomeDate()
    }
    private fun loadHomeDate(){
        val homeData = repository.getHomeData()
        homeData?.let{
            _banners.value = homeData.homeBanner
        }
    }
}