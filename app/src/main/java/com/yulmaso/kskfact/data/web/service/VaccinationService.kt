package com.yulmaso.kskfact.data.web.service

import com.yulmaso.kskfact.data.model.User
import com.yulmaso.kskfact.data.model.Vaccination
import io.reactivex.rxjava3.core.Flowable
import retrofit2.Call
import retrofit2.http.*

interface VaccinationService {
    @GET("/vaccinations")
    fun getAllVaccinations(): Flowable<List<Vaccination>>

    @GET("/vaccinations/{id}")
    fun getVaccination(@Path("id")id: Long): Flowable<Vaccination>

    @POST("/vaccinations")
    fun saveVaccination(@Body vaccination: Vaccination): Flowable<Unit>

    @DELETE("/vaccinations/remove/{id}")
    fun removeVaccination(@Path("id")id: Long): Flowable<Unit>
}