package com.android.asif.weather7daysmvvm.ui.openweather.daily

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.asif.weather7daysmvvm.R
import com.android.asif.weather7daysmvvm.data.db.newentity.Daily
import com.android.asif.weather7daysmvvm.internal.UnitSystem

class ListAdapter(val list: List<Daily>, val unitSystem: UnitSystem, val context: Context): RecyclerView.Adapter<ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_weather_item,parent,false)

        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bindView(list.get(position),context,unitSystem)
    }

    override fun getItemCount(): Int {
       return list.size
    }
}