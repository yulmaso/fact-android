package com.yulmaso.kskfact.ui.horseProfile

import com.yulmaso.kskfact.data.model.Horse

interface HorseProfileNavigator {
    fun goToVaccinationsHistory(horse: Horse)
    fun openAddServiceDialog()
}