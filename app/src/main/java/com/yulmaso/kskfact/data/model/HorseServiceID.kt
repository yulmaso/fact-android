package com.yulmaso.kskfact.data.model

import java.io.Serializable

class HorseServiceID: Serializable {
    var horse: Horse? = null
    var service: Service? = null

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}