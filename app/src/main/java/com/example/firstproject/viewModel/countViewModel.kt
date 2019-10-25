package com.example.firstproject.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.firstproject.CountRepository

class CountViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = CountRepository(application.applicationContext)

    fun getUserCount(name: String) = repository.getUserCount(name + "-count")
    fun setUserCount(name: String, count: Long) = repository.setUserCount(name + "-count", count)

    fun getUserLocation(name: String) = repository.getUserLocation(name + "-location")
    fun setUserLocation(name: String, location: Int) = repository.setUserLocation(name + "-location", location)
}
