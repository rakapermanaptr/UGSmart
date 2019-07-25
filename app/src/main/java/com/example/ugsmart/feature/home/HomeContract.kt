package com.example.ugsmart.feature.home

import com.example.ugsmart.model.BannerData
import com.example.ugsmart.model.Event
import com.example.ugsmart.model.News

interface HomeContract {

    interface View {
        fun showHomeNews(news: MutableList<News>)
        fun showHomeBanner(data: BannerData)
        fun showEventsAndSeminars(events: MutableList<Event>)
    }

    interface Presenter {
        fun getHomeNews()
        fun getHomeBanner()
        fun getEventsAndSeminars()
    }
}