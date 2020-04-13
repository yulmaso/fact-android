package com.yulmaso.kskfact.ui.menu

import android.app.Application
import com.yulmaso.kskfact.data.Repository
import com.yulmaso.kskfact.ui.BaseViewModel
import javax.inject.Inject

class MenuViewModel @Inject constructor(
    application: Application,
    private val repository: Repository
): BaseViewModel(application) {
}