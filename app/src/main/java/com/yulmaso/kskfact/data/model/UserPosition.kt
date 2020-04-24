package com.yulmaso.kskfact.data.model

import com.yulmaso.kskfact.data.model.enums.Position

class UserPosition {
    var user: User? = null
    var position: Position? = null

    var horseAccesses: List<HorseAccess>? = null
}