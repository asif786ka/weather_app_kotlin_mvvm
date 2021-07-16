package com.android.asif.weather7daysmvvm.ui.openweather.daily

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.asif.weather7daysmvvm.data.providers.UnitProvider
import com.android.asif.weather7daysmvvm.data.repository.OpenWeatherRepository

class ListViewModelFactory(
    private val openWeatherRepository: OpenWeatherRepository,
    private val unitProvider: UnitProvider
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ListViewModel(openWeatherRepository,unitProvider) as T
    }
}