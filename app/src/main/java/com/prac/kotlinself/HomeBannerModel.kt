package com.prac.kotlinself

import com.google.gson.annotations.SerializedName

data class HomeData (
   @SerializedName("home_banner") val homeBanner : List<HomeBannerModel>
    )
data class HomeBannerModel(
    @SerializedName("banner_id") val bannerId : Int,
    @SerializedName("banner_image_url") val bannerImageUrl: String,
    @SerializedName("banner_title") val bannerTitle: String,
    @SerializedName("banner_description") val bannerDescription:String
)
