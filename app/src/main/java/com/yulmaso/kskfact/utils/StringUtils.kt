package com.yulmaso.kskfact.utils

import com.yulmaso.kskfact.data.model.UserPosition

fun makePositionsString(list: List<UserPosition>?): String {
    if (list != null) {
        val resultString = String()
        for (position in list) {
            resultString.format(position.position!!.name, ", ")
        }
        return resultString
    } else {
        return ""
    }
}