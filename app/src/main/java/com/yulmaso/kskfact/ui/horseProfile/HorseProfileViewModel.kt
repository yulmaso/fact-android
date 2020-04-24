package com.yulmaso.kskfact.ui.horseProfile

import android.app.Application
import com.yulmaso.kskfact.data.Repository
import com.yulmaso.kskfact.ui.BaseViewModel
import javax.inject.Inject

class HorseProfileViewModel @Inject constructor(
    application: Application,
    private val repository: Repository
): BaseViewModel(application) {

    lateinit var navigator: HorseProfileNavigator

    var horseId: Long? = null

    fun addService() {
        navigator.openAdditionalServiceDialog()
    }

    fun goToVaccinationsHistory() {
        navigator.goToVaccinationsHistory()
    }
}