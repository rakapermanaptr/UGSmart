package com.example.ugsmart.feature.news.sk

import com.example.ugsmart.model.NewsResponse
import com.example.ugsmart.model.repository.NewsRepoImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.ResourceSubscriber
import java.util.*

class SKNewsPresenter(
    private val view: SKNewsContract.View,
    private val newsRepoImpl: NewsRepoImpl
) : SKNewsContract.Presenter {

    val compositeDisposable = CompositeDisposable()

    override fun getAllNews() {
        view.showLoading()
        compositeDisposable.addAll(newsRepoImpl.getAllSKNews()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribeWith(object : ResourceSubscriber<NewsResponse>() {
                override fun onComplete() {
                    view.hideLoading()
                }

                override fun onNext(t: NewsResponse) {
                    view.showAllNews(t.news)
                }

                override fun onError(t: Throwable?) {
                    view.hideLoading()
                    view.showAllNews(Collections.emptyList())
                }

            })
        )
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
    }
}