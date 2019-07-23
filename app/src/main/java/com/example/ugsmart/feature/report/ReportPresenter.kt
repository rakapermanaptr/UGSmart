package com.example.ugsmart.feature.report

import com.example.ugsmart.model.Report
import com.google.firebase.database.*

class ReportPresenter(private val view: ReportContract.View) : ReportContract.Presenter {

    var database: FirebaseDatabase = FirebaseDatabase.getInstance()

    override fun postReport(report: Report) {
        var myRef: DatabaseReference = database.reference.child("reports").child(report.id_report!!)
        myRef.addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                dataSnapshot.ref.setValue(report)
                view.postReport()
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }

        })
    }

}