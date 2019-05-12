package com.example.ugsmart.feature.report

interface ReportContract {

    interface View {
        fun postReport()
    }

    interface Presenter {
        fun postReport(fullname: String, npm: String, subject: String, complaint: String, location: String)
        fun onDestroy()
    }
}