package com.example.ugsmart.feature.news.baak

import com.example.ugsmart.model.News
import com.google.firebase.database.*

class BAAKNewsPresenter(private val view: BAAKNewsContract.View) : BAAKNewsContract.Presenter {

    private var database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private var listSINews: MutableList<News> = mutableListOf()

    override fun getAllNews() {
        view.showLoading()
        var myRef: DatabaseReference = database.reference.child("news").child("baak")
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