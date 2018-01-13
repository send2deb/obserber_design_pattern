package com.debdroid.hf.dp.observer

fun main(args: Array<String>) {
    val weatherData: WeatherData = WeatherData()

    val currentDisplay: CurrentConditionsDisplay = CurrentConditionsDisplay(weatherData)
    val statisticsDisplay: StatisticsDisplay = StatisticsDisplay(weatherData)
    val forecastDisplay: ForecastDisplay = ForecastDisplay(weatherData)
    val heatIndexDisplay: HeatIndexDisplay = HeatIndexDisplay(weatherData)

    weatherData.setMeasurements(80.0f, 65.0f, 30.4f)
    weatherData.setMeasurements(82.0f, 70.0f, 29.2f)
    weatherData.setMeasurements(78.0f, 90.0f, 29.2f);
}