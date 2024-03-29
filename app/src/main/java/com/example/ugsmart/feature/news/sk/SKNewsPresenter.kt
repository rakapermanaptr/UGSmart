package com.example.ugsmart.feature.news.sk

import com.example.ugsmart.model.News
import com.google.firebase.database.*

class SKNewsPresenter(private val view: SKNewsContract.View) : SKNewsContract.Presenter {

    private var database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private var listSKNews: MutableList<News> = mutableListOf()

    override fun getAllNews() {
        view.showLoading()
        var myRef: DatabaseReference = database.reference.child("news").child("sk")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                listSKNews.clear()

                for (dataSnapshot in p0.children) {
                    val data = dataSnapshot.getValue(News::class.java)
                    listSKNews.add(data!!)
                }
                view.showAllNews(listSKNews)
                view.hideLoading()
            }

        })
    }

}