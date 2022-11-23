package com.prac.kotlinself.repository

import com.google.gson.Gson
import com.prac.kotlinself.model.HomeData
import com.prac.kotlinself.repository.common.AssetLoader

class HomeAssetDataSource(private val assetLoader: AssetLoader) :HomeDataSource {
    private val gson= Gson()
    override fun getHomeData(): HomeData? {
       return assetLoader.getJsonString("sample.json")?.let {
               it -> gson.fromJson<HomeData>(it, HomeData::class.java)
        }
    }
}

