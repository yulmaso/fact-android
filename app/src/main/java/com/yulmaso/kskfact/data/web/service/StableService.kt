package com.yulmaso.kskfact.data.web.service

import com.yulmaso.kskfact.data.model.Service
import com.yulmaso.kskfact.data.model.Stable
import io.reactivex.rxjava3.core.Flowable
import retrofit2.Call
import retrofit2.http.*

interface StableService {
    @GET("/stables")
    fun getAllStables(): Flowable<List<Stable>>

    @GET("/stables/{id}")
    fun getStable(@Path("id") id: Int): Flowable<Stable>

    @POST("/stables")
    fun saveStable(@Body horse: Stable): Flowable<Unit>

    @DELETE("/stables/remove/{id}")
    fun removeStable(@Path("id") id: Int): Flowable<Unit>
}