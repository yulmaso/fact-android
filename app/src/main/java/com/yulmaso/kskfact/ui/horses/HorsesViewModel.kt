package com.yulmaso.kskfact.ui.horses

import android.app.Application
import com.yulmaso.kskfact.data.Repository
import com.yulmaso.kskfact.ui.BaseViewModel
import javax.inject.Inject

class HorsesViewModel @Inject constructor(
    application: Application,
    private val repository: Repository
): BaseViewModel(application) {
}