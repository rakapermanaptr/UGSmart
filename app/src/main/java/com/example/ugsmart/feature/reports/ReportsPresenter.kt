package com.example.ugsmart.feature.reports

import com.example.ugsmart.model.ReportResponse
import com.example.ugsmart.model.repository.ReportRepoImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.ResourceSubscriber
import java.util.*

class ReportsPresenter(
    private val view: ReportsContract.View,
    private val reportRepoImpl: ReportRepoImpl
) : ReportsContract.Presenter {

    val compositeDisposable = CompositeDisposable()

    override fun getReports() {
        view.showLoading()
        compositeDisposable.add(reportRepoImpl.getAllReports()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribeWith(object : ResourceSubscriber<ReportResponse>() {
                override fun onComplete() {
                    view.hideLoading()
                }

                override fun onNext(t: ReportResponse) {
                    if (t.reports == null) view.hideLoading() else view.showReports(t.reports)
                }

                override fun onError(t: Throwable?) {
                    view.hideLoading()
                    view.showReports(Collections.emptyList())
                }

            })
        )
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
    }
}