package com.example.ugsmart.model.repository

import com.example.ugsmart.model.EventResponse
import com.example.ugsmart.model.NewsResponse
import io.reactivex.Flowable

interface NewsRepo {

    fun getAllUGNews(): Flowable<NewsResponse>

    fun getAllBAAKNews(): Flowable<NewsResponse>

    fun getAllSINews(): Flowable<NewsResponse>

    fun getAllSKNews(): Flowable<NewsResponse>

    fun getAllTINews(): Flowable<NewsResponse>

    fun getAllCareer(): Flowable<NewsResponse>

    fun getAllEvents(): Flowable<EventResponse>

}