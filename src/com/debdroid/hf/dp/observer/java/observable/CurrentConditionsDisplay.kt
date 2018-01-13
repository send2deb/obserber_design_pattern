package com.debdroid.hf.dp.observer.java.observable

import com.debdroid.hf.dp.observer.DisplayElement
import java.util.*

class CurrentConditionsDisplay(private val observable: Observable) : Observer, DisplayElement {

    private var temperature: Float = 0.0f
    private var humidity: Float = 0.0f
    private var pressure: Float = 0.0f

    init {
        observable.addObserver(this)
    }

    override fun update(o: Observable?, arg: Any?) {
        if (o is WeatherData ) { // Here 'is' is equivalent of java 'instanceof'
            val weatherData: WeatherData = o
            this.temperature = weatherData.getTemperature()
            this.humidity = weatherData.getHumidity()
            display()
        }
    }

    override fun display() {
        println("Current condition: temperature $temperature C and humidity $humidity % humidity")
    }
}