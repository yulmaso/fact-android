package com.yulmaso.kskfact.data

import android.content.SharedPreferences
import com.yulmaso.kskfact.data.model.Event
import com.yulmaso.kskfact.data.model.Horse
import com.yulmaso.kskfact.data.model.Service
import com.yulmaso.kskfact.data.model.User
import com.yulmaso.kskfact.data.web.RetrofitDataSource
import com.yulmaso.kskfact.utils.Constants.AUTH_USER_ID
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(
    private val retrofitDataSource: RetrofitDataSource,
    private val authPreferences: SharedPreferences
) {
    //SharedPreferences:
    fun saveLoggedInUserId(id: Long) = authPreferences.edit().putLong(AUTH_USER_ID, id)
    fun getLoggedInUserId() = authPreferences.getLong(AUTH_USER_ID, 0)

    //Web:
    fun getAllEvents() = retrofitDataSource.getAllEvents()
    fun getEvent(id: Long) = retrofitDataSource.getEvent(id)
    fun saveEvent(event: Event) = retrofitDataSource.saveEvent(event)
    fun removeEvent(id: Long) = retrofitDataSource.removeEvent(id)

    fun getAllHorses() = retrofitDataSource.getAllHorses()
    fun getHorse(id: Long) = retrofitDataSource.getHorse(id)
    fun saveHorse(horse: Horse) = retrofitDataSource.saveHorse(horse)

    fun getAllServices() = retrofitDataSource.getAllServices()
    fun getService(id: Long) = retrofitDataSource.getService(id)
    fun saveService(service: Service) = retrofitDataSource.saveService(service)
    fun removeService(id: Long) = retrofitDataSource.removeService(id)

    fun getAllStables() = retrofitDataSource.getAllStables()
    fun getStable(id: Int) = retrofitDataSource.getStable(id)

    fun getAllUsers() = retrofitDataSource.getAllUsers()
    fun getUser(id: Long) = retrofitDataSource.getUser(id)
    fun saveUser(user: User) = retrofitDataSource.saveUser(user)
    fun removeUser(id: Long) = retrofitDataSource.removeUser(id)

    fun getAllVaccinations() = retrofitDataSource.getAllVaccinations()
    fun getVaccination(id: Long) = retrofitDataSource.getVaccination(id)
}