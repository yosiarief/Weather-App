package com.yosiarief.hipe.ui.fragment.weatherCurrent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yosiarief.hipe.data.repository.WeatherRepository

class CurrentWeatherViewModelFactory (
    private val wetaherRepository: WeatherRepository
) : ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CurrentWeatherViewModel(wetaherRepository) as T
    }
}