package nl.yzaazy.weather.model

data class WeatherData(
    val latitude: Double,
    val longitude: Double,
    val timeZone: String,
    val currently: Currently,
    val offset: Int)

data class Currently(
    val time: Int,
    val summary: String,
    val icon: String,
    val precipIntensity: Double,
    val precipProbability: Double,
    val temperature: Double,
    val apparentTemperature: Double,
    val humidity: Double,
    val windSpeed: Double,
    val uvIndex: Int)