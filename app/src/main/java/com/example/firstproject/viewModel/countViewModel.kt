package com.example.firstproject.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.firstproject.CountRepository
import com.example.firstproject.network.GifRepository

class CountViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = CountRepository(application.applicationContext)
    private val gifRepo = GifRepository()

    fun getGif() = gifRepo.getGif()

    fun getUserCount(name: String) = repository.getUserCount(name + "-count")
    fun setUserCount(name: String, count: Long) = repository.setUserCount(name + "-count", count)

    fun getUserLocation(name: String) = repository.getUserLocation(name + "-location")
    fun setUserLocation(name: String, location: Int) = repository.setUserLocation(name + "-location", location)
}
