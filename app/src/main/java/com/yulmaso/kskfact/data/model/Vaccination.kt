package com.yulmaso.kskfact.data.model

import java.util.*

class Vaccination {
    var id: Long? = null
    var name: String? = null
    var time: Calendar? = null
    var description: String? = null

    var horseVaccinations: MutableList<HorseVaccination>? = null
}