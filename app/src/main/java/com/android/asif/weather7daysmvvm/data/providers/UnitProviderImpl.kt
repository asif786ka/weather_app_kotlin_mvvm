package com.android.asif.weather7daysmvvm.data.providers

import android.content.Context
import com.android.asif.weather7daysmvvm.internal.UnitSystem

class UnitProviderImpl (
        context:Context
): PreferenceProvider(context), UnitProvider {

    override fun unitSystem(): UnitSystem {
        val selectedName = preferences.getString("UNIT_SYSTEM" ,
            UnitSystem.metric.name)?: UnitSystem.metric.name
        return UnitSystem.valueOf(selectedName)

    }
}