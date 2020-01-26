package com.yosiarief.hipe.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import com.google.gson.annotations.SerializedName

data class MetricsCurrentWeatherEntry(
//    @ColumnInfo(name = "temperature")
//    override val temperature: Double,
//    @ColumnInfo(name = "condition_text")
//    override val conditionText: String,
//    @ColumnInfo(name = "condition_icon")
//    override val conditionIconUrl: String,
//    @ColumnInfo(name = "wind_speed")
//    override val windSpeed: Double,
//    @ColumnInfo(name = "wind_dir")
//    override val windDirection: String,
//    @ColumnInfo(name = "precip")
//    override val precipitationVolume: Double,
//    @ColumnInfo(name = "feelslike")
//    override val feelsLikeTemperature: Double,
//    @ColumnInfo(name = "visibility")
//    override val visibilityDistance: Double

    @ColumnInfo(name = "cloudcover")
    override val cloudcover: Int,
    @ColumnInfo(name = "feelslike")
    override val feelslike: Int,
    @ColumnInfo(name = "humidity")
    override val humidity: Int,
    @ColumnInfo(name = "isDay")
    override val isDay: String,
    @ColumnInfo(name = "observationTime")
    override val observationTime: String,
    @ColumnInfo(name = "precip")
    override val precip: Double,
    @ColumnInfo(name = "pressure")
    override val pressure: Int,
    @ColumnInfo(name = "temperature")
    override val temperature: Int,
    @ColumnInfo(name = "uvIndex")
    override val uvIndex: Int,
    @ColumnInfo(name = "visibility")
    override val visibility: Int,
    @ColumnInfo(name = "weatherCode")
    override val weatherCode: Int,
    @ColumnInfo(name = "weatherDescriptions")
    override val weatherDescriptions: List<String>,
    @ColumnInfo(name = "weatherIcons")
    override val weatherIcons: List<String>,
    @ColumnInfo(name = "windDegree")
    override val windDegree: Int,
    @ColumnInfo(name = "windDir")
    override val windDir: String,
    @ColumnInfo(name = "windSpeed")
    override val windSpeed: Int
//    @Embedded(prefix = "condition_")
//    override val condition: Condition
) : UnitSpecificCurrentWeather