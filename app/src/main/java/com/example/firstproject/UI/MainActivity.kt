package com.example.firstproject.UI

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.firstproject.R
import com.example.firstproject.ViewModel.CountViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var countViewModel: CountViewModel

    private var numCounter: Long = 0
    private fun getUsername() = intent.extras?.get("username").toString().toLowerCase(Locale.US)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countViewModel = ViewModelProviders.of(this).get(CountViewModel::class.java)
        countViewModel.getUserCount(getUsername()).observe(this, androidx.lifecycle.Observer { updateCounter(it) })

        clickerButton.setOnClickListener {
            countViewModel.setUserCount(getUsername(), numCounter + 1)
        }
    }

    private fun updateCounter(count: Long) {
        numCounter = count
        counterText.text = numCounter.toString() + " Gallons"
    }
}
