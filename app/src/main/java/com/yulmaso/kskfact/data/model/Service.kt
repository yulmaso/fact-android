package com.yulmaso.kskfact.data.model

class Service {
    var id: Long? = null
    var name: String? = null
    var price: Int? = null

    var horseServices: MutableList<HorseService>? = null
}