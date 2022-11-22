package com.prac.kotlinself.repository

import android.content.Context
import com.google.gson.Gson
import com.prac.kotlinself.HomeData

class HomeAssetDataSource(private val assetLoader:AssetLoader) :HomeDataSource {
    private val gson= Gson()
    override fun getHomeData(): HomeData? {
       return assetLoader.getJsonString("sample.json")?.let {
               it -> gson.fromJson<HomeData>(it, HomeData::class.java)
        }
    }
}

class AssetLoader(private val context: Context){

    fun getJsonString(fileName:String) : String?{
        return kotlin.runCatching {
            loadAsset(fileName)
        }.getOrNull()
    }
    private fun loadAsset(fileName: String): String {
        return context.assets.open(fileName).use { inputStream ->
            val size = inputStream.available()
            val bytes = ByteArray(size)
            inputStream.read(bytes)
            String(bytes)
        }
    }
}