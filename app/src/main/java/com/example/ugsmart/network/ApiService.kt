package com.example.ugsmart.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {

    companion object {
        fun getClient(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("http://10.236.108.102:8888/api-ugsmart/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        }
    }
}