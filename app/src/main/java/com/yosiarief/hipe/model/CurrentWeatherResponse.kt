package com.yosiarief.hipe.model


import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry
//    @SerializedName("location")
//    val location: Location,
//    @SerializedName("request")
//    val request: Request
)