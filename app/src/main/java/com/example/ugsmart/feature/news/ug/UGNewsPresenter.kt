package com.example.ugsmart.feature.news.ug

import com.example.ugsmart.model.News
import com.google.firebase.database.*

class UGNewsPresenter(private val view: UGNewsContract.View) : UGNewsContract.Presenter {

    private var database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private var listUgNews: MutableList<News> = mutableListOf()

    override fun getAllNews() {
        view.showLoading()
        var myRef: DatabaseReference = database.reference.child("news").child("ug")
        myRef.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                listUgNews.clear()

                for (dataSnapshot in p0.children) {
                    val data = dataSnapshot.getValue(News::class.java)
                    listUgNews.add(data!!)
                }
                view.showAllNews(listUgNews)
                view.hideLoading()
            }

        })
    }

}