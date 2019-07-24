package com.example.ugsmart.feature.news.ug

import com.example.ugsmart.model.News
import com.example.ugsmart.model.NewsResponse
import com.example.ugsmart.model.repository.NewsRepoImpl
import com.google.firebase.database.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.ResourceSubscriber
import java.util.*

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