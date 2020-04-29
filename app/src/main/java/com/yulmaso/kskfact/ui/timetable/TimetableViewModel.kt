package com.yulmaso.kskfact.ui.timetable

import android.app.Application
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yulmaso.kskfact.data.Repository
import com.yulmaso.kskfact.data.model.Event
import com.yulmaso.kskfact.ui.BaseViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class TimetableViewModel @Inject constructor(
    application: Application,
    private val repository: Repository
): BaseViewModel(application) {

    var navigator: TimetableNavigator? = null

    val userId = repository.getLoggedInUserId()

    var isLoading = ObservableBoolean()

    private val eventsMLive = MutableLiveData<List<Event>>()
    val events: LiveData<List<Event>> = eventsMLive

    fun updateData() {
        isLoading.set(true)
        disposables.add(
            repository.getAllEvents()
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    isLoading.set(false)
                    eventsMLive.value = it
                }, {
                    isLoading.set(false)
                    eventsMLive.value = null
                    handleRequestFailure(it)
                })
        )
    }

    fun newEvent() {
        navigator?.newEvent()
    }

}