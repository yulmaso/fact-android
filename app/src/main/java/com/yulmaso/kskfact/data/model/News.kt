package com.yulmaso.kskfact.data.model

import java.util.*

data class News (
    var id: Long? = null,
    var title: String? = null,
    var content: String? = null,
    var time: Calendar? = null
)