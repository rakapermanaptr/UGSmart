package com.example.ugsmart.network

import com.example.ugsmart.model.BannerDataResponse
import com.example.ugsmart.model.EventResponse
import com.example.ugsmart.model.NewsResponse
import com.example.ugsmart.model.ReportResponse
import io.reactivex.Flowable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiRest {

    @GET("banner.php")
    fun getBannerData(): Flowable<BannerDataResponse>

    @GET("event.php")
    fun getAllEvents(): Flowable<EventResponse>

    @GET("career.php")
    fun getAllCareer(): Flowable<NewsResponse>

    @GET("news-ti.php")
    fun getAllTINews(): Flowable<NewsResponse>

    @GET("news-sk.php")
    fun getAllSKNews(): Flowable<NewsResponse>

    @GET("news-si.php")
    fun getAllSINews(): Flowable<NewsResponse>

    @GET("news-baak.php")
    fun getAllBAAKNews(): Flowable<NewsResponse>

    @GET("news-ug.php")
    fun getAllUGNews(): Flowable<NewsResponse>

    @GET("view.php")
    fun getAllReports(): Flowable<ReportResponse>

    @POST("create-report.php")
    @FormUrlEncoded
    fun postReport(
        @Field("fullname") fullname: String,
        @Field("npm") npm: String,
        @Field("subject") subject: String,
        @Field("complaint") complaint: String,
        @Field("location") location: String
    ): Flowable<ReportResponse>

}