package com.example.ugsmart.feature.news.si

import com.example.ugsmart.model.News

interface SINewsContract {

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