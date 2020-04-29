package com.yulmaso.kskfact.ui.horseProfile

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yulmaso.kskfact.data.Repository
import com.yulmaso.kskfact.data.model.Horse
import com.yulmaso.kskfact.data.model.Vaccination
import com.yulmaso.kskfact.ui.BaseViewModel
import javax.inject.Inject

class HorseProfileViewModel @Inject constructor(
    application: Application,
    private val repository: Repository
): BaseViewModel(application) {

    lateinit var navigator: HorseProfileNavigator

    var horseMLive = MutableLiveData<Horse>()
    var horse: LiveData<Horse> = horseMLive

    fun setProfileHorse(horse: Horse) {
        horseMLive.value = horse
    }

    fun addService() {
        navigator.openAddServiceDialog()
    }

    fun cancelVaccination(vaccination: Vaccination) {

    }

    fun goToVaccinationsHistory() {
        navigator.goToVaccinationsHistory(horse.value!!)
    }
}