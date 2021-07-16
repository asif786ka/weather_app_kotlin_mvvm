package com.android.asif.weather7daysmvvm.ui.openweather.daily

import androidx.lifecycle.ViewModel
import com.android.asif.weather7daysmvvm.data.providers.UnitProvider
import com.android.asif.weather7daysmvvm.data.repository.OpenWeatherRepository
import com.android.asif.weather7daysmvvm.internal.UnitSystem
import com.android.asif.weather7daysmvvm.internal.lazyDeferred

class ListViewModel (
    private val openWeatherRepository: OpenWeatherRepository,
    unitProvider: UnitProvider
): ViewModel() {
    val unitSystem=unitProvider.unitSystem()//UnitSystem.METRIC //get from settings

    val isMetric:Boolean
        get() = unitSystem== UnitSystem.metric

    val dailyWeather by lazyDeferred {
        openWeatherRepository.getDailyWeather(unitSystem.name)
    }
    val locationName by lazyDeferred {
        openWeatherRepository.getLocationName()
    }
}