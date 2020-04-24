package com.yulmaso.kskfact.data.web.service

import com.yulmaso.kskfact.data.model.Horse
import io.reactivex.rxjava3.core.Flowable
import retrofit2.Call
import retrofit2.http.*

interface HorseService {
    @GET("/horses")
    fun getAllHorses(): Flowable<List<Horse>>

    @GET("/horses/{id}")
    fun getHorse(@Path("id")id: Long): Flowable<Horse>

    @POST("/horses")
    fun saveHorse(@Body horse: Horse): Flowable<Unit>

    @DELETE("/horses/remove/{id}")
    fun removeHorse(@Path("id")id: Long): Flowable<Unit>
}