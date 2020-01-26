package com.yosiarief.hipe.ui.fragment.weatherCurrent

import androidx.lifecycle.ViewModel
import com.yosiarief.hipe.data.repository.WeatherRepository
import com.yosiarief.hipe.internal.UnitSystem
import com.yosiarief.hipe.internal.lazyDeferred

class CurrentWeatherViewModel(
    private val weatherRepository: WeatherRepository
) : ViewModel() {
    private val unitSystem = UnitSystem.METRIC

    val isMetric: Boolean
    get() = unitSystem == UnitSystem.METRIC

    val weather by lazyDeferred() {
        weatherRepository.getCurrentWeather(isMetric)
    }
}
