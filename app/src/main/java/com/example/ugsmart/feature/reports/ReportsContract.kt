package com.example.ugsmart.feature.reports

import com.example.ugsmart.model.Report

interface ReportsContract {

    interface View {
        fun showLoading()
        fun hideLoading()
        fun showReports(report: List<Report>)
    }

    interface Presenter {
        fun getReports()
        fun onDestroy()
    }

}