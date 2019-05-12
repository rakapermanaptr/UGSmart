package com.example.ugsmart.model

data class Report(
    val id: String,
    val fullname: String,
    val npm: String,
    val subject: String,
    val complaint: String,
    val location: String,
    val note: String
)