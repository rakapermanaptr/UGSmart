package com.example.ugsmart.feature.news.sk

import com.example.ugsmart.model.News

interface SKNewsContract {

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