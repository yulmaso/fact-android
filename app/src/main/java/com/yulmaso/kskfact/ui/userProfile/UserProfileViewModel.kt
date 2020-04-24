package com.yulmaso.kskfact.ui.userProfile

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yulmaso.kskfact.data.Repository
import com.yulmaso.kskfact.data.model.User
import com.yulmaso.kskfact.ui.BaseViewModel
import com.yulmaso.kskfact.utils.makePositionsString
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class UserProfileViewModel @Inject constructor(
    application: Application,
    private val repository: Repository
): BaseViewModel(application) {

    private var userMLive = MutableLiveData<User>()
    var user: LiveData<User> = userMLive

    private var positionMLive = MutableLiveData<String>()
    var position: LiveData<String> = positionMLive

    fun updateData(userId: Long) {
        requestListener?.onStarted()
        disposables.add(
            repository.getUser(userId)
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({result ->
                    requestListener?.onSuccess()
                    userMLive.value = result
                    positionMLive.value = makePositionsString(result.positions)
                }, {
                    requestListener?.onFailure(it.message!!)
                })
        )
    }
}