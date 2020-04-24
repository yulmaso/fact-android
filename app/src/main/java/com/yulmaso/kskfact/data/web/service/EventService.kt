package com.yulmaso.kskfact.data.web.service

import com.yulmaso.kskfact.data.model.Event
import com.yulmaso.kskfact.data.model.Vaccination
import io.reactivex.rxjava3.core.Flowable
import retrofit2.Call
import retrofit2.http.*

interface EventService {
    @GET("/events")
    fun getAllEvents(): Flowable<List<Event>>

    @GET("/events/{id}")
    fun getEvent(@Path("id")id: Long): Flowable<Event>

    @POST("/events")
    fun saveEvent(@Body event: Event): Flowable<Unit>

    @DELETE("/events/remove/{id}")
    fun removeEvent(@Path("id")id: Long): Flowable<Unit>
}