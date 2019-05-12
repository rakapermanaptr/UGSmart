package com.example.ugsmart.feature.report

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.ugsmart.R
import com.example.ugsmart.model.repository.ReportRepoImpl
import com.example.ugsmart.network.ApiRest
import com.example.ugsmart.network.ApiService
import kotlinx.android.synthetic.main.activity_report.*
import org.jetbrains.anko.toast

class ReportActivity : AppCompatActivity(), ReportContract.View {

    private lateinit var presenter: ReportPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)

        val service = ApiService.getClient().create(ApiRest::class.java)
        val request = ReportRepoImpl(service)
        presenter = ReportPresenter(this, request)

        btnReport.setOnClickListener {
            val fullname = edtFullname.text.toString()
            val npm = edtNpm.text.toString()
            val subject = edtSubject.text.toString()
            val complaint = edtComplaint.text.toString()
            val location = edtLocation.text.toString()

            presenter.postReport(fullname, npm, subject, complaint, location)

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

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}
