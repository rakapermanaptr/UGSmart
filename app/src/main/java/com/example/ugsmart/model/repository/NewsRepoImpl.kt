package com.example.ugsmart.model.repository

import com.example.ugsmart.model.EventResponse
import com.example.ugsmart.model.NewsResponse
import com.example.ugsmart.network.ApiRest
import io.reactivex.Flowable

class NewsRepoImpl(private val apiRest: ApiRest) : NewsRepo {

    override fun getAllEvents(): Flowable<EventResponse> = apiRest.getAllEvents()

    override fun getAllCareer(): Flowable<NewsResponse> = apiRest.getAllCareer()

    override fun getAllTINews(): Flowable<NewsResponse> = apiRest.getAllTINews()

    override fun getAllSKNews(): Flowable<NewsResponse> = apiRest.getAllSKNews()

    override fun getAllSINews(): Flowable<NewsResponse> = apiRest.getAllSINews()

    override fun getAllBAAKNews(): Flowable<NewsResponse> = apiRest.getAllBAAKNews()

    override fun getAllUGNews(): Flowable<NewsResponse> = apiRest.getAllUGNews()
}