package com.yulmaso.kskfact.data.web.service

import com.yulmaso.kskfact.data.model.Service
import io.reactivex.rxjava3.core.Flowable
import retrofit2.Call
import retrofit2.http.*

interface ServicesService {
    @GET("/services")
    fun getAllServices(): Flowable<List<Service>>

    @GET("/services/{id}")
    fun getService(@Path("id") id: Long): Flowable<Service>

    @POST("/services")
    fun saveService(@Body service: Service): Flowable<Unit>

    @DELETE("/services/remove/{id}")
    fun removeService(@Path("id") id: Long): Flowable<Unit>
}