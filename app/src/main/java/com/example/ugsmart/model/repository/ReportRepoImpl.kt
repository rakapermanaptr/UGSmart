package com.example.ugsmart.model.repository

import com.example.ugsmart.model.ReportResponse
import com.example.ugsmart.network.ApiRest
import io.reactivex.Flowable

class ReportRepoImpl(private val apiRest: ApiRest) : ReportRepo {

    override fun postReport(
        fullname: String,
        npm: String,
        subject: String,
        complaint: String,
        location: String
    ): Flowable<ReportResponse> = apiRest.postReport(fullname, npm, subject, complaint, location)

    override fun getAllReports(): Flowable<ReportResponse> = apiRest.getAllReports()
}