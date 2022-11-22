package com.prac.kotlinself

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.prac.kotlinself.repository.HomeAssetDataSource

class HomeViewModel(private val repository: HomeAssetDataSource) : ViewModel() {
    private val _banners = MutableLiveData<List<HomeBannerModel>>()
    val banners : LiveData<List<HomeBannerModel>> = _banners
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