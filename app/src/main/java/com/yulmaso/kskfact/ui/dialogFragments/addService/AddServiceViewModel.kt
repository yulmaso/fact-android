package com.yulmaso.kskfact.ui.dialogFragments.addService

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yulmaso.kskfact.data.Repository
import com.yulmaso.kskfact.data.model.Horse
import com.yulmaso.kskfact.data.model.HorseService
import com.yulmaso.kskfact.data.model.Service
import com.yulmaso.kskfact.ui.BaseViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class AddServiceViewModel @Inject constructor(
    application: Application,
    private val repository: Repository
): BaseViewModel(application) {

    var navigator: AddServiceDialogNavigator? = null

    var horse: Horse? = null

    val resultCostMLive = MutableLiveData<String>()
    val resultCost: LiveData<String> = resultCostMLive

    val createdHorseServiceMLive = MutableLiveData<HorseService>()
    val createdHorseService: LiveData<HorseService> = createdHorseServiceMLive

    val chosenServiceMLive = MutableLiveData<Service>()
    val chosenService: LiveData<Service> = chosenServiceMLive

    private val servicesMLive = MutableLiveData<List<Service>>()
    val services: LiveData<List<Service>> = servicesMLive

    init {
        requestListener?.onStarted()
        disposables.add(
            repository.getAllServices()
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    requestListener?.onSuccess()
                    servicesMLive.value = it
                }, {
                    requestListener?.onFailure(it.message!!)
                })
        )
    }

    fun addService() {
        requestListener?.onStarted()
        horse!!.horseServices!!.add(createdHorseService.value!!)
        disposables.add(
            repository.saveHorse(horse!!)
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    requestListener?.onSuccess()
                    navigator?.goBack()
                }, {
                    requestListener?.onFailure(it.message!!)
                })
        )
    }

    fun cancelAdding() {
        navigator?.goBack()
    }
}