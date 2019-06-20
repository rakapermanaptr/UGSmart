package com.example.ugsmart.feature.home

import android.util.Log
import com.example.ugsmart.model.BannerDataResponse
import com.example.ugsmart.model.EventResponse
import com.example.ugsmart.model.NewsResponse
import com.example.ugsmart.model.repository.NewsRepoImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.ResourceSubscriber

class HomePresenter(private val view: HomeContract.View,
                    private val newsRepoImpl: NewsRepoImpl)
    : HomeContract.Presenter{

    val compositeDisposable = CompositeDisposable()

    override fun getHomeNews() {
        compositeDisposable.add(newsRepoImpl.getAllUGNews()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribeWith(object : ResourceSubscriber<NewsResponse>() {
                override fun onComplete() {
                    Log.i("Data", "Home news complete")
                }

                override fun onNext(t: NewsResponse) {
                    view.showHomeNews(t.news)
                }

                override fun onError(t: Throwable?) {
                    Log.e("Error", "home news error")
                }

            }))
    }

    override fun getEventsAndSeminars() {
        compositeDisposable.add(newsRepoImpl.getAllEvents()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribeWith(object : ResourceSubscriber<EventResponse>() {
                override fun onComplete() {
                    Log.i("Data", "Home event complete")
                }

                override fun onNext(t: EventResponse) {
                    view.showEventsAndSeminars(t.events)
                }

                override fun onError(t: Throwable?) {
                    Log.e("Error", "home event error")
                }

            }))
    }

    override fun getHomeBanner() {
        compositeDisposable.add(newsRepoImpl.getAllBannerData()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribeWith(object : ResourceSubscriber<BannerDataResponse>() {
                override fun onComplete() {
                    Log.i("Data", "Home banner complete")
                }

                override fun onNext(t: BannerDataResponse) {
                    view.showHomeBanner(t.data)
                }

                override fun onError(t: Throwable?) {
                    Log.e("Error", "home banner error")
                }

            }))
    }
}