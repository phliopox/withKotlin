package com.prac.kotlinself.repository

import com.prac.kotlinself.HomeBannerModel
import com.prac.kotlinself.HomeData

interface HomeDataSource {
    fun getHomeData(): HomeData?
}