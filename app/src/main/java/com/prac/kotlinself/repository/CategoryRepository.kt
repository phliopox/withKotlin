package com.prac.kotlinself.repository

import com.google.gson.Gson
import com.prac.kotlinself.model.Categories
import com.prac.kotlinself.model.CategoryItem
import com.prac.kotlinself.repository.common.AssetLoader

class CategoryRepository(private val assetLoader: AssetLoader) : CategoryDataSource {
    private val gson = Gson()
    override fun getCategories() : Categories? {
        return assetLoader.getJsonString("categories.json")?.let{
        jsonString -> gson.fromJson<Categories>(jsonString,Categories::class.java)
        }
    }
}