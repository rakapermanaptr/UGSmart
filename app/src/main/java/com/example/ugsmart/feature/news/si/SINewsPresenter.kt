package com.example.ugsmart.feature.news.si

import com.example.ugsmart.model.News
import com.google.firebase.database.*

class SINewsPresenter(private val view: SINewsContract.View) : SINewsContract.Presenter {

    private var database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private var listSINews: MutableList<News> = mutableListOf()

    override fun getAllNews() {
        view.showLoading()
        var myRef: DatabaseReference = database.reference.child("news").child("si")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                listSINews.clear()

                for (dataSnapshot in p0.children) {
                    val data = dataSnapshot.getValue(News::class.java)
                    listSINews.add(data!!)
                }
                view.showAllNews(listSINews)
                view.hideLoading()
            }

        })
    }

}