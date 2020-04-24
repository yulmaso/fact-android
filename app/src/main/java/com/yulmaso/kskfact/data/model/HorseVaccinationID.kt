package com.yulmaso.kskfact.data.model

import java.io.Serializable

class HorseVaccinationID: Serializable {
    var horse: Horse? = null
    var vaccination: Vaccination? = null

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}