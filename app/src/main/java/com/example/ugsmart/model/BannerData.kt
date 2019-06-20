package com.example.ugsmart.model

import com.google.gson.annotations.SerializedName

data class BannerData(
    @SerializedName("announcement_title")
    val announcement_title: String,
    @SerializedName("announcement")
    val announcement: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("rector_greeting")
    val rectorGreeting: String,
    @SerializedName("rector_img")
    val rectorImg: String,
    @SerializedName("rector_name")
    val rectorName: String
)