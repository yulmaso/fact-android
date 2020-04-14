package com.yulmaso.kskfact.ui.settings

import android.app.Application
import com.yulmaso.kskfact.data.Repository
import com.yulmaso.kskfact.ui.BaseViewModel
import javax.inject.Inject

class SettingsViewModel @Inject constructor(
    application: Application,
    private val repository: Repository
): BaseViewModel(application) {

    var email: String? = null
    var login: String? = null
    var pushNotifications: Boolean? = null
    var beforeVaccination: Int? = null
    var planningVaccination: Boolean? = null

    var settingsNavigator: SettingsNavigator? = null

    fun logOut() {
        settingsNavigator?.goToLogin()
    }
    fun changePassword() {}
}