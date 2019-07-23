package com.example.ugsmart.feature.report

import com.example.ugsmart.model.Report

interface ReportContract {

    interface View {
        fun postReport()
    }

    interface Presenter {
        fun postReport(report: Report)
    }
}