package com.yulmaso.kskfact.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel

abstract class BaseViewModel(application: Application): AndroidViewModel(application) {

    var requestListener: RequestListener? = null

//    //disposable to dispose the Completable
//    protected val disposables = CompositeDisposable()
//
//    //disposing the disposables
//    override fun onCleared() {
//        super.onCleared()
//        disposables.dispose()
//    }

}