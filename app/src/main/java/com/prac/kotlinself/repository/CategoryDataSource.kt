package com.prac.kotlinself.repository

import com.prac.kotlinself.model.Categories
import com.prac.kotlinself.model.CategoryItem

interface CategoryDataSource{
      fun getCategories() : Categories?
}