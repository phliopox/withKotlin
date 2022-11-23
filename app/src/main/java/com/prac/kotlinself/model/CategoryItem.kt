package com.prac.kotlinself.model

import com.google.gson.annotations.SerializedName

data class CategoryItem (
    val alphabet : String,
    @SerializedName("name") val categoryName:String
        )
data class Categories(
  val categories : List<CategoryItem>
)
