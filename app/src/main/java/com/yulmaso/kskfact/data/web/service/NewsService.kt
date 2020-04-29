package com.yulmaso.kskfact.data.web.service

import com.yulmaso.kskfact.data.model.News
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.*

interface NewsService {
    @GET("/news")
    fun getAllNews(): Flowable<List<News>>

    @GET("/news/{id}")
    fun getNews(@Path("id") id: Long): Flowable<News>

    @POST("/news")
    fun saveNews(@Body news: News): Flowable<Unit>

    @DELETE("/news/remove/{id}")
    fun removeNews(@Path("id") id: Long): Flowable<Unit>
}