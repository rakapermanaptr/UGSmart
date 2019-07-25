package com.example.ugsmart.feature.career

import com.example.ugsmart.model.News

interface CareerCenterContract {

    interface View {
        fun showLoading()
        fun hideLoading()
        fun showAllCareer(careers: MutableList<News>)
    }

    interface Presenter {
        fun getAllCareer()
    }
}