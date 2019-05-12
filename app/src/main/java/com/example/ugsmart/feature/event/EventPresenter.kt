package com.example.ugsmart.feature.event

import com.example.ugsmart.model.EventResponse
import com.example.ugsmart.model.repository.NewsRepoImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.ResourceSubscriber
import java.util.*

class EventPresenter(
    private val view: EventContract.View,
    private val newsRepoImpl: NewsRepoImpl
) : EventContract.Presenter {

    val compositeDisposable = CompositeDisposable()

    override fun getAllEvents() {
        view.showLoading()
        compositeDisposable.addAll(newsRepoImpl.getAllEvents()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribeWith(object : ResourceSubscriber<EventResponse>() {
                override fun onComplete() {
                    view.hideLoading()
                }

                override fun onNext(t: EventResponse) {
                    view.showAllEvents(t.events)
                }

                override fun onError(t: Throwable?) {
                    view.hideLoading()
                    view.showAllEvents(Collections.emptyList())
                }

            })
        )
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
    }
}