package com.yulmaso.kskfact.data.model

import com.yulmaso.kskfact.data.model.enums.Gender
import java.io.Serializable


class Horse: Serializable {
    var id: Long? = null
    var name: String? = null //кличка
    var owner: User? = null //хозяин
    var stable: Stable? = null //конюшня
    var gender: Gender? = null //пол
    var breed: String? = null //порода
    var age: String? = null //возраст
    var isAtClub: Boolean? = null //находится в клубе
    var horseOnQuarantine: HorseQuarantine? = null

    var horseAccess: MutableList<HorseAccess>? = null
    var horseServices: MutableList<HorseService>? = null
    var horseVaccinations: MutableList<HorseVaccination>? = null
    var events: List<Event>? = null
}