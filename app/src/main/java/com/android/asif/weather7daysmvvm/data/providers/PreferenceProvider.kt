package com.android.asif.weather7daysmvvm.data.providers

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

abstract class PreferenceProvider(context : Context) {


    private val appContext=context.applicationContext
    protected val preferences : SharedPreferences
        get()=  PreferenceManager.getDefaultSharedPreferences(appContext)
}