package com.yulmaso.kskfact.ui.vaccinationsHistory

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yulmaso.kskfact.data.Repository
import com.yulmaso.kskfact.data.model.Horse
import com.yulmaso.kskfact.data.model.HorseVaccination
import com.yulmaso.kskfact.data.model.Vaccination
import com.yulmaso.kskfact.ui.BaseViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class VaccinationsHistoryViewModel @Inject constructor(
    application: Application,
    val repository: Repository
): BaseViewModel(application) {
    var horse: Horse? = null
    var vaccinationsMLive = MutableLiveData<List<HorseVaccination>>()
    var vaccinations: LiveData<List<HorseVaccination>> = vaccinationsMLive

    fun updateVaccinations() {
        requestListener?.onStarted()
        disposables.add(
            repository.getHorse(horse!!.id!!)
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    vaccinationsMLive.value = it.horseVaccinations
                    requestListener?.onSuccess()
                }, {
                    requestListener?.onFailure(it.message!!)
                })
        )
    }

}