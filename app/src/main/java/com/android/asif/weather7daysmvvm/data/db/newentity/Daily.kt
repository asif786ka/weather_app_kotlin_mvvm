package com.android.asif.weather7daysmvvm.data.db.newentity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.android.asif.weather7daysmvvm.data.network.response.Temp
import com.android.asif.weather7daysmvvm.data.network.response.Weather

@Entity(tableName = "dailyWeather")
data class Daily(
    @PrimaryKey(autoGenerate = true)
        var DailyId: Int,
    @SerializedName("clouds")
    val clouds: Int,
    @SerializedName("dew_point")
    val dewPoint: Double,
    @SerializedName("dt")
    val dt: Int,
    @SerializedName("feels_like")
    @Embedded(prefix="feelslike_")
    val feelsLike: FeelsLike,
    @SerializedName("humidity")
    val humidity: Int,
    @SerializedName("pop")
    val pop: Double,
    @SerializedName("pressure")
    val pressure: Int,
    @SerializedName("rain")
    val rain: Double,
    @SerializedName("sunrise")
    val sunrise: Int,
    @SerializedName("sunset")
    val sunset: Int,
    @SerializedName("temp")
    @Embedded(prefix="temp_")
    val temp: Temp,
    @SerializedName("uvi")
    val uvi: Double,
    @SerializedName("weather")
    val weather: List<Weather>,
    @SerializedName("wind_deg")
    val windDeg: Int,
    @SerializedName("wind_speed")
    val windSpeed: Double
)