package com.prac.kotlinself

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.prac.kotlinself.repository.CategoryRepository
import com.prac.kotlinself.repository.common.AssetLoader
import com.prac.kotlinself.repository.HomeAssetDataSource
import com.prac.kotlinself.ui.category.CategoryViewModel
import com.prac.kotlinself.ui.home.HomeViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(private val context: Context):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java)->{
                val repository = HomeAssetDataSource(AssetLoader(context))
                HomeViewModel(repository) as T
            }
            modelClass.isAssignableFrom(CategoryViewModel::class.java)->{
                val repository = CategoryRepository(AssetLoader(context))
                CategoryViewModel(repository) as T
            }
            else -> {throw IllegalArgumentException("Failed to create ViewModel : ${modelClass.name}")}
        }
    }
}