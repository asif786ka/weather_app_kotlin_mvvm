package com.android.asif.weather7daysmvvm.data.network.response


import com.google.gson.annotations.SerializedName
import com.android.asif.weather7daysmvvm.data.db.newentity.Current
import com.android.asif.weather7daysmvvm.data.db.newentity.Daily
import com.android.asif.weather7daysmvvm.data.db.newentity.Hourly

data class openWeatherResponse(
    @SerializedName("current")
    val current: Current,
    @SerializedName("daily")
    val daily: List<Daily>,
    @SerializedName("hourly")
    val hourly: List<Hourly>,
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lon")
    val lon: Double,
    @SerializedName("timezone")
    val timezone: String,
    @SerializedName("timezone_offset")
    val timezoneOffset: Int
)