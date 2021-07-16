package com.android.asif.weather7daysmvvm

import android.app.Application
import android.content.Context
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.gms.location.LocationServices
import com.jakewharton.threetenabp.AndroidThreeTen
import com.android.asif.weather7daysmvvm.data.db.OpenWeatherDatabase
import com.android.asif.weather7daysmvvm.data.network.*
import com.android.asif.weather7daysmvvm.data.providers.*
import com.android.asif.weather7daysmvvm.data.repository.OpenWeatherRepository
import com.android.asif.weather7daysmvvm.data.repository.OpenWeatherRepositoryImpl
import com.android.asif.weather7daysmvvm.ui.openweather.current.OpenWeatherViewModelFactory
import com.android.asif.weather7daysmvvm.ui.openweather.daily.ListViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class WeatherApp: Application() , KodeinAware {
    override val kodein= Kodein.lazy {

        import(androidXModule(this@WeatherApp))
        bind() from singleton { OpenWeatherDatabase(instance()) }
        bind() from singleton { instance<OpenWeatherDatabase>().newCurrentDao() }
        bind() from singleton { instance<OpenWeatherDatabase>().newDailyDao() }
        bind() from singleton { instance<OpenWeatherDatabase>().newHourlyDao() }
        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }
        bind() from singleton { OpenWeatherApiService(instance()) }
        bind<OpenWeatherNetworkDataSource>() with singleton { OpenWeatherNetworkDataSourceImpl(instance()) }
        bind() from provider { LocationServices.getFusedLocationProviderClient(instance<Context>())}
        bind<locationProvider>() with singleton { locationProviderImpl(instance(),instance()) }
        bind<OpenWeatherRepository>() with singleton { OpenWeatherRepositoryImpl(instance(),instance(),instance(),instance(),instance()) }//new
        bind<UnitProvider>() with singleton { UnitProviderImpl(instance()) }
        bind() from provider { OpenWeatherViewModelFactory(instance(),instance()) }
        bind() from provider { ListViewModelFactory(instance(),instance()) }
    }

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
        PreferenceManager.setDefaultValues(this, R.xml.preferences,false)
        val theme = ThemeProvider(this).getThemeFromPreferences()
        AppCompatDelegate.setDefaultNightMode(theme)
    }
}