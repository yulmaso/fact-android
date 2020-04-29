package com.yulmaso.kskfact.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.yulmaso.kskfact.data.web.CalendarDeserializer
import com.yulmaso.kskfact.data.web.service.*
import com.yulmaso.kskfact.utils.Constants
import com.yulmaso.kskfact.utils.Constants.AUTH_PREFERENCES
import dagger.Module
import dagger.Provides
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    fun gsonDateFormat(): Gson = GsonBuilder()
        .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
        .registerTypeAdapter(Calendar::class.java, CalendarDeserializer())
        .create()

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    @Provides
    fun provideAuthPreferences(application: Application): SharedPreferences =
        application.getSharedPreferences(AUTH_PREFERENCES, Context.MODE_PRIVATE)

    @Provides
    fun provideEventService(r: Retrofit) = r.create(EventService::class.java)

    @Provides
    fun provideHorseService(r: Retrofit) = r.create(HorseService::class.java)

    @Provides
    fun provideNewsService(r: Retrofit) = r.create(NewsService::class.java)

    @Provides
    fun provideServicesService(r: Retrofit) = r.create(ServicesService::class.java)

    @Provides
    fun provideStableService(r: Retrofit) = r.create(StableService::class.java)

    @Provides
    fun provideUserService(r: Retrofit) = r.create(UserService::class.java)

    @Provides
    fun provideVaccinationService(r: Retrofit) = r.create(VaccinationService::class.java)
}