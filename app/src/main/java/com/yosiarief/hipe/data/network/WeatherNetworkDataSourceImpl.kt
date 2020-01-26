package com.yosiarief.hipe.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yosiarief.hipe.model.CurrentWeatherResponse

class WeatherNetworkDataSourceImpl(
    private val apiWeatherStackApiService: WeatherStackApiService
) : WeatherNetworkDataSource {

    private val _downloadCurrentWeather = MutableLiveData<CurrentWeatherResponse>()
    override val downloadCurrentWeather: LiveData<CurrentWeatherResponse>
        get() = _downloadCurrentWeather //To change initializer of created properties use File | Settings | File Templates.

    override suspend fun fetchCurrentWeather(location: String) {
        try {
            val fetchCurrentWeather = apiWeatherStackApiService
                .getCurrentWeather(location)
                .await()
            _downloadCurrentWeather.postValue(fetchCurrentWeather)
        }
        catch (e: NoConnectivityException){
            Log.e("Connectivity", "No Internet Connection", e)
        }
    }
}