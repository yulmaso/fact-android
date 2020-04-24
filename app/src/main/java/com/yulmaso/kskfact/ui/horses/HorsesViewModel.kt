package com.yulmaso.kskfact.ui.horses

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yulmaso.kskfact.data.Repository
import com.yulmaso.kskfact.data.model.Horse
import com.yulmaso.kskfact.ui.BaseViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class HorsesViewModel @Inject constructor(
    application: Application,
    private val repository: Repository
): BaseViewModel(application) {
    private val horsesMLive = MutableLiveData<List<Horse>>()
    val horses: LiveData<List<Horse>> = horsesMLive

    init {
        requestListener?.onStarted()
        disposables.add(
            repository.getAllHorses()
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    horsesMLive.value = it
                    requestListener?.onSuccess()
                }, {
                    requestListener?.onFailure(it.message!!)
                })
        )
    }
}