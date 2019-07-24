package com.example.ugsmart.feature.news.ti

import com.example.ugsmart.model.News
import com.example.ugsmart.model.NewsResponse
import com.example.ugsmart.model.repository.NewsRepoImpl
import com.google.firebase.database.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.ResourceSubscriber
import java.util.*

class TINewsPresenter(private val view: TINewsContract.View) : TINewsContract.Presenter {

    private var database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private var listTINews: MutableList<News> = mutableListOf()

    override fun getAllNews() {
        view.showLoading()
        var myRef: DatabaseReference = database.reference.child("news").child("ti")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                listTINews.clear()

                for (dataSnapshot in p0.children) {
                    val data = dataSnapshot.getValue(News::class.java)
                    listTINews.add(data!!)
                }
                view.showAllNews(listTINews)
                view.hideLoading()
            }

        })
    }

}