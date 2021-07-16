package com.android.asif.weather7daysmvvm.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.android.asif.weather7daysmvvm.data.db.newentity.Current
import com.android.asif.weather7daysmvvm.data.db.newentity.Daily
import com.android.asif.weather7daysmvvm.data.db.newentity.Hourly
import com.android.asif.weather7daysmvvm.internal.WeatherTypeConvertor

@Database(
        entities=[Current::class, Daily::class, Hourly::class],
        version=1
)
@TypeConverters(WeatherTypeConvertor::class)
abstract class OpenWeatherDatabase: RoomDatabase()  {
    abstract fun newCurrentDao(): NewCurrentDao
    abstract fun newDailyDao() : NewDailyDao
    abstract fun newHourlyDao() : NewHourlyDao

    companion object{
        @Volatile private var instance : OpenWeatherDatabase?=null
        //so that no two threads access at same time
        private val LOCK=Any()
        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance =it }
        }

        private fun buildDatabase(context: Context)=
                Room.databaseBuilder(context.applicationContext,
                        OpenWeatherDatabase::class.java,"currentNewWeather.db")
                        .build()
    }
}