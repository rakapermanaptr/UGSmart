package com.example.ugsmart.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Event(
    val date: String,
    val description: String,
    val id: String,
    val location: String,
    val time: String,
    val title: String,
    val url: String
) : Parcelable