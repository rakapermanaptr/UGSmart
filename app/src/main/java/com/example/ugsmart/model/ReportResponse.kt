package com.example.ugsmart.model

import com.google.gson.annotations.SerializedName

data class ReportResponse(
    @SerializedName("reports")
    val reports: List<Report>
)