package com.android.asif.weather7daysmvvm.data.network

import androidx.lifecycle.LiveData
import com.android.asif.weather7daysmvvm.data.network.response.openWeatherResponse

interface OpenWeatherNetworkDataSource {
    val downloadedOpenWeather : LiveData<openWeatherResponse>

    suspend fun fetchOpenWeather(
            lat:Double,
            lon:Double,
            unit:String
    )
}