package com.debdroid.hf.dp.observer.java.observable

import com.debdroid.hf.dp.observer.DisplayElement
import java.util.*

class ForecastDisplay(private val observable: Observable) : Observer, DisplayElement {
    private var currentPressure = 29.92f
    private var lastPressure: Float = 0.toFloat()

    init {
        observable.addObserver(this)
    }

    override fun update(o: Observable?, arg: Any?) {
        if (o is WeatherData ) { // Here 'is' is equivalent of java 'instanceof'
            val weatherData: WeatherData = o
            lastPressure = currentPressure
            currentPressure = weatherData.getPressure()
            display()
        }
    }

    override fun display() {
        print("Forecast: ")
        if (currentPressure > lastPressure) {
            println("Improving weather on the way!")
        } else if (currentPressure == lastPressure) {
            println("More of the same")
        } else if (currentPressure < lastPressure) {
            println("Watch out for cooler, rainy weather")
        }
    }
}