package com.android.asif.weather7daysmvvm.data.db.newentity

import com.google.gson.annotations.SerializedName

data class FeelsLike(
    @SerializedName("day")
    val day: Double,
    @SerializedName("eve")
    val eve: Double,
    @SerializedName("morn")
    val morn: Double,
    @SerializedName("night")
    val night: Double
)