package com.yulmaso.kskfact.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable

abstract class BaseViewModel(application: Application): AndroidViewModel(application) {

    var requestListener: RequestListener? = null

//    //disposable to dispose the Completable
    protected val disposables = CompositeDisposable()

    //disposing the disposables
    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }
}