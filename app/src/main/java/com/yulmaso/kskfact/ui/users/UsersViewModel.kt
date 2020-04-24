package com.yulmaso.kskfact.ui.users

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yulmaso.kskfact.data.Repository
import com.yulmaso.kskfact.data.model.User
import com.yulmaso.kskfact.ui.BaseViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class UsersViewModel @Inject constructor(
    application: Application,
    private val repository: Repository
): BaseViewModel(application) {
    private val usersMLive = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> = usersMLive

    init {
        requestListener?.onStarted()
        disposables.add(
            repository.getAllUsers()
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    usersMLive.value = it
                    requestListener?.onSuccess()
                }, {
                    requestListener?.onFailure(it.message!!)
                })
        )
    }
}