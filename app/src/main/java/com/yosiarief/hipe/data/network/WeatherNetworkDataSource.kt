package com.yosiarief.hipe.data.network

import androidx.lifecycle.LiveData
import com.yosiarief.hipe.model.CurrentWeatherResponse

interface WeatherNetworkDataSource {
    val downloadCurrentWeather: LiveData<CurrentWeatherResponse>

    suspend fun fetchCurrentWeather(
        location: String)
}