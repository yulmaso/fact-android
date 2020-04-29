package com.yulmaso.kskfact.ui.news

import android.app.Application
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yulmaso.kskfact.data.Repository
import com.yulmaso.kskfact.data.model.News
import com.yulmaso.kskfact.ui.BaseViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class NewsViewModel @Inject constructor(
    application: Application,
    private val repository: Repository
): BaseViewModel(application) {

    val isLoading = ObservableBoolean()

    private val newsMLive = MutableLiveData<List<News>>()
    val news: LiveData<List<News>> = newsMLive

    fun updateData() {
        isLoading.set(true)
        disposables.add(
            repository.getAllNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    isLoading.set(false)
                    newsMLive.value = it
                }, {
                    isLoading.set(false)
                    newsMLive.value = null
                    handleRequestFailure(it)
                })
        )
    }
}