package com.yosiarief.hipe

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import com.yosiarief.hipe.data.network.*
import com.yosiarief.hipe.data.repository.WeatherRepository
import com.yosiarief.hipe.data.repository.WeatherRepositoryImpl
import com.yosiarief.hipe.data.room.WeatherDatabase
import com.yosiarief.hipe.ui.fragment.weatherCurrent.CurrentWeatherViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.androidModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class WeatherApplication: Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidModule(this@WeatherApplication))

        bind() from singleton {WeatherDatabase(instance())}
        bind() from singleton { instance<WeatherDatabase>().currentWatherDao() }
        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }
        bind() from singleton { WeatherStackApiService(instance()) }
        bind<WeatherNetworkDataSource>() with singleton { WeatherNetworkDataSourceImpl(instance()) }
        bind<WeatherRepository>() with singleton { WeatherRepositoryImpl(instance(), instance()) }
        bind() from provider { CurrentWeatherViewModelFactory(instance()) }
    }

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
    }
}