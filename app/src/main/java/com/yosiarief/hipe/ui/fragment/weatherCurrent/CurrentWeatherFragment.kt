package com.yosiarief.hipe.ui.fragment.weatherCurrent

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

import com.yosiarief.hipe.R
import com.yosiarief.hipe.data.network.ConnectivityInterceptorImpl
import com.yosiarief.hipe.data.network.WeatherNetworkDataSourceImpl
import com.yosiarief.hipe.data.network.WeatherStackApiService
import com.yosiarief.hipe.internal.GlideApp
import com.yosiarief.hipe.ui.base.ScopedFragment
import kotlinx.android.synthetic.main.current_weather_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

class CurrentWeatherFragment : ScopedFragment(), KodeinAware {

    override val kodein by closestKodein()

    private val viewModelFactory : CurrentWeatherViewModelFactory by instance()


    private lateinit var viewModel: CurrentWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.current_weather_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        viewModel = ViewModelProvider(this).get(CurrentWeatherViewModel::class.java)
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(CurrentWeatherViewModel::class.java)

        bindUI()
        // TODO: Use the ViewModel
//        val apiService = WeatherStackApiService(ConnectivityInterceptorImpl(this.context!!))
//        val weatherNetworkDataSource = WeatherNetworkDataSourceImpl(apiService)
//
//        weatherNetworkDataSource.downloadCurrentWeather.observe(this, Observer {
//            tv.text = it.toString()
//        })
//
//        GlobalScope.launch(Dispatchers.Main) {
//            weatherNetworkDataSource.fetchCurrentWeather("Bandung")
//        }
    }

    private fun bindUI()= launch{
        val currentWeather = viewModel.weather.await()
        currentWeather.observe(this@CurrentWeatherFragment, Observer {
            if (it == null) return@Observer

            group_loading.visibility = View.GONE
            updateLocation("Bandung")
            updateDateToToday()
            updateTemperature(it.temperature, it.feelslike)
            updateCondition(it.weatherDescriptions.get(0))
            updatePrecipitation(it.precip)
            updateWind(it.windDir, it.windSpeed)
            updateVisibility(it.visibility)

            GlideApp.with(this@CurrentWeatherFragment)
                .load(it.weatherIcons[0])
                .into(imageView_condition_icon)
        })
    }

    private fun chooseLocalizedUnit(metrics: String, imperial: String): String{
        return if (viewModel.isMetric) metrics else "F"
    }

    private fun updateLocation(locatio: String){
        (activity as? AppCompatActivity)?.supportActionBar?.title = locatio
    }

    private fun updateDateToToday(){
        (activity as? AppCompatActivity)?.supportActionBar?.subtitle = "Hari Ini"
    }

    private fun updateTemperature(temperature: Int, feelsLike: Int){
        val unitAbbrevation = chooseLocalizedUnit("C", "F")
        textView_temperature.text = "$temperature$unitAbbrevation"
        textView_feels_like_temperature.text = "Feels like $feelsLike$unitAbbrevation"
    }

    private fun updateCondition(condition: String){
        textView_condition.text = condition
    }

    private fun updatePrecipitation(precipitationVolume: Double){
        val unitAbbrevation = chooseLocalizedUnit("mm", "in")
        textView_precipitation.text = "Preciptiation: $precipitationVolume $unitAbbrevation"
    }

    private fun updateWind(windDirection: String, windSpeed: Int){
        val unitAbbrevation = chooseLocalizedUnit("kph", "mph")
        textView_wind.text = "Wind: $windDirection, $windSpeed $unitAbbrevation"
    }

    private fun updateVisibility(visible: Int){
        val unitAbbrevation = chooseLocalizedUnit("km", "mi")
        textView_visibility.text = "Visibility: $visible $unitAbbrevation"
    }

}
