package com.yulmaso.kskfact.ui.login

import android.app.Application
import com.yulmaso.kskfact.data.Repository
import com.yulmaso.kskfact.ui.BaseViewModel
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    application: Application,
    private val repository: Repository
): BaseViewModel(application) {

    var login: String? = null
    var password: String? = null

    fun login() {}

}