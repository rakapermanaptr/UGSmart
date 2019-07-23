package com.example.ugsmart.feature.reports

import com.example.ugsmart.model.Report
import com.example.ugsmart.model.ReportResponse
import com.example.ugsmart.model.repository.ReportRepoImpl
import com.google.firebase.database.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.ResourceSubscriber
import java.util.*

class ReportsPresenter(private val view: ReportsContract.View) : ReportsContract.Presenter {

    private var database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private var listReports: MutableList<Report> = mutableListOf()

    override fun getReports() {
        view.showLoading()
        var myRef: DatabaseReference = database.reference.child("reports")
        myRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(p0: DataSnapshot) {
                listReports.clear()

                for (dataSnapshot in p0.children) {
                    val data = dataSnapshot.getValue(Report::class.java)
                    listReports.add(data!!)
                }
                view.showReports(listReports)
                view.hideLoading()
            }

            override fun onCancelled(p0: DatabaseError) {

            }

        })
    }

}