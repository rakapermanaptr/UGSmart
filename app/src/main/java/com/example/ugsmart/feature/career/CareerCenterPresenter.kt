package com.example.ugsmart.feature.career

import com.example.ugsmart.model.NewsResponse
import com.example.ugsmart.model.repository.NewsRepoImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.ResourceSubscriber
import java.util.*

class CareerCenterPresenter(
    private val view: CareerCenterContract.View,
    private val newsRepoImpl: NewsRepoImpl
) : CareerCenterContract.Presenter {

    val compositeDisposable = CompositeDisposable()

    override fun getAllCareer() {
        view.showLoading()
        compositeDisposable.addAll(newsRepoImpl.getAllCareer()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribeWith(object : ResourceSubscriber<NewsResponse>() {
                override fun onComplete() {
                    view.hideLoading()
                }

                override fun onNext(t: NewsResponse) {
                    view.showAllCareer(t.news)
                }

                override fun onError(t: Throwable?) {
                    view.hideLoading()
                    view.showAllCareer(Collections.emptyList())
                }

            })
        )
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
    }
}