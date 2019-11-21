package com.example.firstproject

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class UploadWorker(appContext: Context, workerParams: WorkerParameters)
    : Worker(appContext, workerParams) {

    private val repository: CountRepository = CountRepository(appContext)
    override fun doWork(): Result {
        // Do the work here--in this case, upload the images.
        backgroundAction()
        // Indicate whether the task finished successfully with the Result
        return Result.success()
    }

    private fun backgroundAction(): String {
        return "background action complete"
    }
}