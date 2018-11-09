package nl.yzaazy.weather.app

import nl.yzaazy.weather.model.WeatherData

interface DataCallback {
    fun dataCallback(weatherData: WeatherData)
}
