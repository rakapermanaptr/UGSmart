package com.example.ugsmart.feature.news.ug

import com.example.ugsmart.model.News

interface UGNewsContract {

    interface View {
        fun showLoading()
        fun hideLoading()
        fun showAllNews(news: MutableList<News>)
    }

    interface Presenter {
        fun getAllNews()
    }
}