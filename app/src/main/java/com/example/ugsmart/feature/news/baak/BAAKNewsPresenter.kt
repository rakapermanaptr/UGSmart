package com.example.ugsmart.feature.news.baak

import com.example.ugsmart.model.NewsResponse
import com.example.ugsmart.model.repository.NewsRepoImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.ResourceSubscriber
import java.util.*

class BAAKNewsPresenter(
    private val view: BAAKNewsContract.View,
    private val newsRepoImpl: NewsRepoImpl
) : BAAKNewsContract.Presenter {

    val compositeDisposable = CompositeDisposable()

    override fun getAllNews() {
        view.showLoading()
        compositeDisposable.addAll(newsRepoImpl.getAllBAAKNews()
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