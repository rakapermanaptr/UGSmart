package com.example.ugsmart.feature.home

import com.example.ugsmart.model.BannerData
import com.example.ugsmart.model.Event
import com.example.ugsmart.model.News

interface HomeContract {

    interface View {
        fun showHomeNews(news: List<News>)
        fun showHomeBanner(data: List<BannerData>)
        fun showEventsAndSeminars(events: List<Event>)
    }

    interface Presenter {
        fun getHomeNews()
        fun getHomeBanner()
        fun getEventsAndSeminars()
    }
}