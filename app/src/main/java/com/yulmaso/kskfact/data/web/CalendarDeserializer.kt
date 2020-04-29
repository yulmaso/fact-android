package com.yulmaso.kskfact.data.web

import com.google.gson.*
import java.lang.reflect.Type
import java.text.SimpleDateFormat
import java.util.*

class CalendarDeserializer: JsonDeserializer<Calendar> {

    private val calendarFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US)

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Calendar {
        val s = json!!.asString
        s.let {
            val calendar = Calendar.getInstance()
            calendar.time = calendarFormat.parse(it)!!
            return calendar
        }
    }
}