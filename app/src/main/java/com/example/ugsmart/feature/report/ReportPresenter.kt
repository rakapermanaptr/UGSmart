package com.example.ugsmart.feature.report

import android.util.Log
import com.example.ugsmart.model.ReportResponse
import com.example.ugsmart.model.repository.ReportRepoImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.ResourceSubscriber

class ReportPresenter(
    private val view: ReportContract.View,
    private val reportRepoImpl: ReportRepoImpl
) : ReportContract.Presenter {

    val compositeDisposable = CompositeDisposable()

    override fun postReport(fullname: String, npm: String, subject: String, complaint: String, location: String) {
        compositeDisposable.add(
            reportRepoImpl.postReport(fullname, npm, subject, complaint, location)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(object : ResourceSubscriber<ReportResponse>() {
                    override fun onComplete() {
                        Log.i("onComplete", "Data has benn sent")
                        view.postReport()
                    }

                    override fun onNext(t: ReportResponse) {
                        view.postReport()
                    }

                    override fun onError(t: Throwable) {
                        Log.e("onError Post", t.message)
                    }

                })
        )
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
    }
}