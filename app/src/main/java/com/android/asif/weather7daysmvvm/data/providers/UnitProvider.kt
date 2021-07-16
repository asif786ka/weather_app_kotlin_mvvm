package com.android.asif.weather7daysmvvm.data.providers

import com.android.asif.weather7daysmvvm.internal.UnitSystem

interface UnitProvider {
    fun unitSystem(): UnitSystem
}