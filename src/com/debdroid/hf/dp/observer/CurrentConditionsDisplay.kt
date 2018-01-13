package com.debdroid.hf.dp.observer

class CurrentConditionsDisplay(private val weatherData: Subject) : Observer, DisplayElement {
    private var temperature: Float = 0.0f
    private var humidity: Float = 0.0f
    private var pressure: Float = 0.0f

    init {
        weatherData.registerObserver(this)
    }

    override fun update(temp: Float, humidity: Float, pressure: Float) {
        this.temperature = temp
        this.humidity = humidity
        display()
    }

    override fun display() {
        println("Current condition: temperature $temperature C and humidity $humidity % humidity")
    }
}