package com.yulmaso.kskfact.utils

import java.text.DateFormatSymbols
import java.text.SimpleDateFormat
import java.util.*

object Constants {
    const val LOG_TAG = "myLogs"

    const val BASE_URL = "https://cec02e65.ngrok.io"

    val yearFormat = SimpleDateFormat("yyyy", Locale.US)
    val monthFormat = SimpleDateFormat("MM", Locale.US)
    val dayFormat = SimpleDateFormat("dd", Locale.US)
    val dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.US)
    val timeFormat = SimpleDateFormat("HH:mm", Locale.US)

    //preferences
    const val AUTH_PREFERENCES = "AUTH_PREFERENCES"
    const val AUTH_USER_ID = "AUTH_USER_ID"
}