package com.yulmaso.kskfact.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.yulmaso.kskfact.App
import com.yulmaso.kskfact.R
import io.reactivex.rxjava3.disposables.CompositeDisposable
import retrofit2.HttpException

abstract class BaseViewModel(application: Application): AndroidViewModel(application) {

    var requestListener: RequestListener? = null

//    //disposable to dispose the Completable
    protected val disposables = CompositeDisposable()

    //disposing the disposables
    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }

    fun handleRequestFailure(exception: Throwable) {
        if (exception is HttpException) {
            when (exception.code()) {
                404 -> requestListener?.onFailure(getApplication<App>().resources.getString(R.string.error_404))
                else -> requestListener?.onFailure("exception " + exception.code())
            }
        } else {
            requestListener?.onFailure(exception.message!!)
        }
    }
}