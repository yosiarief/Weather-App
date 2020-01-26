package com.yosiarief.hipe.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.yosiarief.hipe.model.CurrentWeatherEntry


@Database(
    entities = [CurrentWeatherEntry::class],
    version = 1
)
@TypeConverters(Convert::class)
abstract class WeatherDatabase: RoomDatabase() {
    abstract fun currentWatherDao(): CurrentWeatherDao

    companion object{
        @kotlin.jvm.Volatile private var instance: WeatherDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                WeatherDatabase::class.java, "forecast.db")
                .fallbackToDestructiveMigration()
                .build()

    }
}