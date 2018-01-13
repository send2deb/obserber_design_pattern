package com.debdroid.hf.dp.observer

interface Observer {
    fun update(temp: Float, humidity: Float, pressure: Float)
}