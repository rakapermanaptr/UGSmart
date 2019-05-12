package com.example.ugsmart.feature.news.ti

import com.example.ugsmart.model.News

interface TINewsContract {

    interface View {
        fun showLoading()
        fun hideLoading()
        fun showAllNews(news: List<News>)
    }

    interface Presenter {
        fun getAllNews()
        fun onDestroy()
    }
}