package com.debdroid.hf.dp.observer.java.observable

import java.util.*

class WeatherData : Observable() {
    private var temperature: Float = 0.0f
    private var humidity: Float = 0.0f
    private var pressure: Float = 0.0f

    fun setMeasurements(temperature: Float, humidity: Float, pressure: Float) {
        this.temperature = temperature
        this.humidity = humidity
        this.pressure = pressure
        measurementChanged()
    }

    private fun measurementChanged() {
        setChanged()
        notifyObservers()
    }

    fun getTemperature() = temperature
    fun getHumidity() = humidity
    fun getPressure() = pressure
}