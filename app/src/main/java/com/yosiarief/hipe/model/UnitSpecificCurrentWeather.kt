package com.yosiarief.hipe.model

import androidx.room.Embedded
import com.google.gson.annotations.SerializedName

interface UnitSpecificCurrentWeather {
//    val temperature: Double
//    val conditionText: String
//    val conditionIconUrl: String
//    val windSpeed: Double
//    val windDirection: String
//    val precipitationVolume: Double
//    val feelsLikeTemperature: Double
//    val visibilityDistance: Double
    val cloudcover: Int
    val feelslike: Int
    val humidity: Int
    val isDay: String
    val observationTime: String
    val precip: Double
    val pressure: Int
    val temperature: Int
    val uvIndex: Int
    val visibility: Int
    val weatherCode: Int
    val weatherDescriptions: List<String>
    val weatherIcons: List<String>
    val windDegree: Int
    val windDir: String
    val windSpeed: Int
//    val condition: Condition
}