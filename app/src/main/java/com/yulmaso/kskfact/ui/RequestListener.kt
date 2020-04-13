package com.yulmaso.kskfact.ui

interface RequestListener {
    fun onStarted()
    fun onSuccess()
    fun onFailure(message: String)
}