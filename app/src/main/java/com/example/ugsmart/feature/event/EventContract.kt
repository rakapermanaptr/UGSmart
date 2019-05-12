package com.example.ugsmart.feature.event

import com.example.ugsmart.model.Event

interface EventContract {

    interface View {
        fun showLoading()
        fun hideLoading()
        fun showAllEvents(events: List<Event>)
    }

    interface Presenter {
        fun getAllEvents()
        fun onDestroy()
    }
}