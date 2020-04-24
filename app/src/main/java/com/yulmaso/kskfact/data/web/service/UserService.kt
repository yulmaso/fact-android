package com.yulmaso.kskfact.data.web.service

import com.yulmaso.kskfact.data.model.User
import io.reactivex.rxjava3.core.Flowable
import retrofit2.Call
import retrofit2.http.*

interface UserService {
    @GET("/users")
    fun getAllUsers(): Flowable<List<User>>

    @GET("/users/{id}")
    fun getUser(@Path("id")id: Long): Flowable<User>

    @POST("/users")
    fun saveUser(@Body user: User): Flowable<Unit>

    @DELETE("/users/remove/{id}")
    fun removeUser(@Path("id")id: Long): Flowable<Unit>
}