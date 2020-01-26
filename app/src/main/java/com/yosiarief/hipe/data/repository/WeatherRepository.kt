package com.yosiarief.hipe.data.repository

import androidx.lifecycle.LiveData
import com.yosiarief.hipe.model.CurrentWeatherResponse
import com.yosiarief.hipe.model.UnitSpecificCurrentWeather

interface WeatherRepository {
    suspend fun getCurrentWeather(metrics: Boolean): LiveData<out UnitSpecificCurrentWeather>
}