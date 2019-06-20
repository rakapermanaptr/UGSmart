package com.example.ugsmart.model

import com.google.gson.annotations.SerializedName

data class BannerDataResponse(
    @SerializedName("data")
    val `data`: List<BannerData>
)