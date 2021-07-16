package com.android.asif.weather7daysmvvm.ui.openweather.current

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.asif.weather7daysmvvm.data.providers.UnitProvider
import com.android.asif.weather7daysmvvm.data.repository.OpenWeatherRepository

class OpenWeatherViewModelFactory(
    private val openWeatherRepository: OpenWeatherRepository,
    private val unitProvider: UnitProvider
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return OpenWeatherViewModel(openWeatherRepository,unitProvider) as T
    }
}