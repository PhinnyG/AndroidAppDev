package com.example.firstproject

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import me.ibrahimsn.library.LiveSharedPreferences

class CountRepository(context: Context) {
    private val preferences: SharedPreferences
    private val liveSharedPreferences: LiveSharedPreferences

    init {
        preferences = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        liveSharedPreferences = LiveSharedPreferences(preferences)
    }

    fun setUserCount(name: String, count: Long) =
        preferences.edit().putLong(name, count).apply()

    fun getUserCount(name: String): LiveData<Long> =
        Transformations.map(liveSharedPreferences.listenMultiple(listOf(name), 0L)) { it[name]}

    fun getUserLocation(name: String): LiveData<Int> =
        Transformations.map(liveSharedPreferences.listenMultiple(listOf(name), 0)) { it[name]}

    fun setUserLocation(name: String, location: Int) =
        preferences.edit().putInt(name, location).apply()

    companion object {
        private const val PREFS = "clickCounts"
    }
}
