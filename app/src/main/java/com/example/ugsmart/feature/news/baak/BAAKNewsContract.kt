package com.example.ugsmart.feature.news.baak

import com.example.ugsmart.model.News

interface BAAKNewsContract {

    interface View {
        fun showLoading()
        fun hideLoading()
        fun showAllNews(news: MutableList<News>)
    }

    interface Presenter {
        fun getAllNews()
    }
}