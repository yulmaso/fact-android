package com.yulmaso.kskfact.data.model

import java.util.*

class Event {
    var id: Long? = null
    var horse: Horse? = null
    var trainer: User? = null
    var startTime: Calendar? = null
    var endTime: Calendar? = null
    var enabled: Boolean? = null
    var eventType: Event? = null
}