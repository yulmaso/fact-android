package com.yulmaso.kskfact.ui.timetable

import android.app.Application
import com.yulmaso.kskfact.data.Repository
import com.yulmaso.kskfact.ui.BaseViewModel
import javax.inject.Inject

class TimetableViewModel @Inject constructor(
    application: Application,
    private val repository: Repository
): BaseViewModel(application) {

    fun newEvent() {}

}