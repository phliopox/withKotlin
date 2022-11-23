package com.prac.kotlinself.repository

import com.prac.kotlinself.model.HomeData

interface HomeDataSource {
    fun getHomeData(): HomeData?
}