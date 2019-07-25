package com.example.ugsmart.feature.home

import android.util.Log
import com.example.ugsmart.model.*
import com.example.ugsmart.model.repository.NewsRepoImpl
import com.google.firebase.database.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.ResourceSubscriber

class HomePresenter(private val view: HomeContract.View) : HomeContract.Presenter {

    private var database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private var listEvents: MutableList<Event> = mutableListOf()
    private var listNews: MutableList<News> = mutableListOf()
    private lateinit var bannerData: BannerData


    override fun getHomeNews() {
        var myRef: DatabaseReference = database.reference.child("news").child("ug")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                listNews.clear()

                for (dataSnapshot in p0.children) {
                    val data = dataSnapshot.getValue(News::class.java)
                    listNews.add(data!!)
                }
                view.showHomeNews(listNews)
            }

        })
    }

    override fun getEventsAndSeminars() {
        var myRef: DatabaseReference = database.reference.child("event")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                listEvents.clear()

                for (dataSnapshot in p0.children) {
                    val data = dataSnapshot.getValue(Event::class.java)
                    listEvents.add(data!!)
                }
                view.showEventsAndSeminars(listEvents)
            }

        })
    }

    override fun getHomeBanner() {
        var myRef: DatabaseReference = database.reference.child("banner_home")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {

                bannerData = p0.getValue(BannerData::class.java)!!

                view.showHomeBanner(bannerData)
            }

        })
    }
}