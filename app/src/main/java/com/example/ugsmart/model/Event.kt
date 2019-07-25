package com.example.ugsmart.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Event(
    val date: String? = null,
    val description: String? = null,
    val id_event: String? = null,
    val location: String? = null,
    val time: String? = null,
    val title: String? = null,
    val url: String? = null
) : Parcelable