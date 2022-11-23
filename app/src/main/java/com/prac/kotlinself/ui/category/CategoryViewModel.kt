package com.prac.kotlinself.ui.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.prac.kotlinself.model.CategoryItem
import com.prac.kotlinself.repository.CategoryRepository

class CategoryViewModel(private val categoryRepository: CategoryRepository):ViewModel(){

    private val _category = MutableLiveData<List<CategoryItem>>()
    val category : LiveData<List<CategoryItem>> = _category

    init {
        loadData()
    }

    private fun loadData(){
        val categories = categoryRepository.getCategories()
        categories?.let{
            _category.value=categories.categories
        }
    }
}