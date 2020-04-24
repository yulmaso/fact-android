package com.yulmaso.kskfact.data.model

import com.yulmaso.kskfact.data.model.enums.Position
import java.io.Serializable

class UserPositionID: Serializable {
    var user: User? = null
    var position: Position? = null

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}