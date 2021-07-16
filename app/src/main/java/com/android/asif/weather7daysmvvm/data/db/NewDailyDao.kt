package com.android.asif.weather7daysmvvm.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.asif.weather7daysmvvm.data.db.newentity.Daily

@Dao
interface NewDailyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(dailyWeather: Daily)

    @Query("select * from dailyWeather")
    fun getDailyWeather(): LiveData<List<Daily>>

    @Query("delete from dailyWeather")
    fun deleteDailyWeather()
}