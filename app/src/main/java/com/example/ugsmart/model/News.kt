package com.example.ugsmart.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class News(
    val date: String? = "",
    val description: String? = "",
    val id_news: String? = "",
    val title: String? = ""
) : Parcelable