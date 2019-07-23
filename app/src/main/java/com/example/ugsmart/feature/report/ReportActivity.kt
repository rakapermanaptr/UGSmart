package com.example.ugsmart.feature.report

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.ugsmart.R
import com.example.ugsmart.model.Report
import com.example.ugsmart.model.repository.ReportRepoImpl
import com.example.ugsmart.network.ApiRest
import com.example.ugsmart.network.ApiService
import kotlinx.android.synthetic.main.activity_report.*
import org.jetbrains.anko.toast
import java.time.LocalDateTime

class ReportActivity : AppCompatActivity(), ReportContract.View {

    private lateinit var presenter: ReportPresenter
    private lateinit var report: Report
    private var localDate = System.currentTimeMillis()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)

        presenter = ReportPresenter(this)

        btnReport.setOnClickListener {
            val fullname = edtFullname.text.toString()
            val npm = edtNpm.text.toString()
            val subject = edtSubject.text.toString()
            val complaint = edtComplaint.text.toString()
            val location = edtLocation.text.toString()

            report = Report(localDate.toString(), fullname, npm, subject, complaint, location)

            presenter.postReport(report)

            toast("Report has been sent !")

            edtFullname.setText("")
            edtNpm.setText("")
            edtComplaint.setText("")
            edtSubject.setText("")
            edtComplaint.setText("")
            edtLocation.setText("")

            finish()
        }
    }

    override fun postReport() {
        toast("Report has been sent !")
    }

}
