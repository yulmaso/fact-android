package com.yulmaso.kskfact.ui.users

import android.app.Application
import com.yulmaso.kskfact.data.Repository
import com.yulmaso.kskfact.ui.BaseViewModel
import javax.inject.Inject

class UsersViewModel @Inject constructor(
    application: Application,
    private val repository: Repository
): BaseViewModel(application) {
}