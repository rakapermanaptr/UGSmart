package com.example.ugsmart.feature.career

import com.example.ugsmart.model.News
import com.google.firebase.database.*

class CareerCenterPresenter(private val view: CareerCenterContract.View) : CareerCenterContract.Presenter {

    private var database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private var listCareer: MutableList<News> = mutableListOf()

    override fun getAllCareer() {
        view.showLoading()
        var myRef: DatabaseReference = database.reference.child("career")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                listCareer.clear()

                for (dataSnapshot in p0.children) {
                    val data = dataSnapshot.getValue(News::class.java)
                    listCareer.add(data!!)
                }
                view.showAllCareer(listCareer)
                view.hideLoading()
            }

        })
    }

}