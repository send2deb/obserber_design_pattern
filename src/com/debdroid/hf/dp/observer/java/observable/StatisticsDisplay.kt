package com.debdroid.hf.dp.observer.java.observable

import com.debdroid.hf.dp.observer.DisplayElement
import java.util.*

class StatisticsDisplay(private val observable: Observable) : Observer, DisplayElement {

    private var maxTemp = 0.0f
    private var minTemp = 200f
    private var tempSum = 0.0f
    private var numReadings: Int = 0

    init {
        observable.addObserver(this)
    }


    override fun update(o: Observable?, arg: Any?) {
        if (o is WeatherData ) { // Here 'is' is equivalent of java 'instanceof'
            val weatherData: WeatherData = o
            tempSum += weatherData.getTemperature()
            numReadings++

            if (weatherData.getTemperature() > maxTemp) {
                maxTemp = weatherData.getTemperature()
            }

            if (weatherData.getTemperature() < minTemp) {
                minTemp = weatherData.getTemperature()
            }
            display()
        }
    }

    override fun display() {
        println("Avg/Max/Min temperature = " + tempSum / numReadings
                + "/" + maxTemp + "/" + minTemp)
    }
}