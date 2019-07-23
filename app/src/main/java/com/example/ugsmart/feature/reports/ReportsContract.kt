package com.example.ugsmart.feature.reports

import com.example.ugsmart.model.Report

interface ReportsContract {

    interface View {
        fun showLoading()
        fun hideLoading()
        fun showReports(report: MutableList<Report>)
    }

    interface Presenter {
        fun getReports()
    }

}