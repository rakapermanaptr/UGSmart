package com.example.ugsmart.model.repository

import com.example.ugsmart.model.ReportResponse
import io.reactivex.Flowable

interface ReportRepo {
    fun getAllReports(): Flowable<ReportResponse>

    fun postReport(
        fullname: String,
        npm: String,
        subject: String,
        complaint: String,
        location: String
    ): Flowable<ReportResponse>
}