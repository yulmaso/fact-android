package com.yulmaso.kskfact.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.yulmaso.kskfact.data.web.RetrofitClientInstance
import com.yulmaso.kskfact.utils.Constants.AUTH_PREFERENCES
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class AppModule {
    @Provides
    fun provideRetrofit(): Retrofit = RetrofitClientInstance.getRetrofitInstance()

    @Provides
    fun provideAuthPreferences(application: Application): SharedPreferences =
        application.getSharedPreferences(AUTH_PREFERENCES, Context.MODE_PRIVATE)
}