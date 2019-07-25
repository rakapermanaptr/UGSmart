package com.example.ugsmart.feature.event

import com.example.ugsmart.model.Event

interface EventContract {

    interface View {
        fun showLoading()
        fun hideLoading()
        fun showAllEvents(events: MutableList<Event>)
    }

    interface Presenter {
        fun getAllEvents()
    }
}