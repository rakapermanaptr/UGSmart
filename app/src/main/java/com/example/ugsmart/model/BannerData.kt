package com.example.ugsmart.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BannerData(
    val announcement_title: String? = null,
    val announcement: String? = null,
    val id: String? = null,
    val rectorGreeting: String? = null,
    val rectorImg: String? = null,
    val rectorName: String? = null
): Parcelable