package com.debdroid.hf.dp.observer

class WeatherData (private val observers: ArrayList<Observer> = arrayListOf()) : Subject {
    private var temperature: Float = 0.0f
    private var humidity: Float = 0.0f
    private var pressure: Float = 0.0f

    override fun registerObserver(o: Observer) {
        observers.add(o)
        println("Register observer ${o.toString()}")
    }

    override fun unRegisterObserver(o: Observer) {
        val index: Int = observers.indexOf(o)
        if (index > 0) unRegisterObserver(o)
        println("Unregister observer ${o.toString()}")
    }

    override fun notifyObserver() {
        observers.indices
                .map { observers[it] }
                .forEach { it.update(temperature, humidity, pressure) }
    }

    fun setMeasurements(temperature: Float, humidity: Float, pressure: Float) {
        this.temperature = temperature
        this.humidity = humidity
        this.pressure = pressure
        measurementChanged()
    }

    private fun measurementChanged() {
        notifyObserver()
    }
}