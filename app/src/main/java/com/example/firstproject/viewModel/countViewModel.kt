package com.example.firstproject.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.example.firstproject.CountRepository
import com.example.firstproject.UploadWorker
import com.example.firstproject.network.GifRepository

class CountViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = CountRepository(application.applicationContext)
    private val gifRepo = GifRepository()
    private val workManager = WorkManager.getInstance(application)

    fun getGif() = gifRepo.getGif()

    internal fun doBackgroundWork() {
        workManager.enqueue(OneTimeWorkRequest.from(UploadWorker::class.java))
    }

    fun getUserCount(name: String) = repository.getUserCount(name + "-count")
    fun setUserCount(name: String, count: Long) = repository.setUserCount(name + "-count", count)

    fun getUserLocation(name: String) = repository.getUserLocation(name + "-location")
    fun setUserLocation(name: String, location: Int) = repository.setUserLocation(name + "-location", location)
}
