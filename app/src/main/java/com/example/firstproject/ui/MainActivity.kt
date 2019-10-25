package com.example.firstproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.example.firstproject.R
import com.example.firstproject.viewModel.CountViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var countViewModel: CountViewModel

    private var numCounter: Long = 0
    private var locationNum: Int = 0
    private fun getUsername() = intent.extras?.get("username").toString().toLowerCase(Locale.US)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countViewModel = ViewModelProviders.of(this).get(CountViewModel::class.java)
        countViewModel.getUserCount(getUsername()).observe(this, androidx.lifecycle.Observer<Long> { updateCounter(it) })
        countViewModel.getUserLocation(getUsername()).observe(this, androidx.lifecycle.Observer<Int> { updateLocation(it) })

        clickerButton.setOnClickListener {
            countViewModel.setUserCount(getUsername(), numCounter + 1)
            checkCounter(numCounter)
        }

        centerButton.setOnClickListener {
            countViewModel.setUserLocation(getUsername(), locationNum + 1)
            clickerButton.setImageResource(R.drawable.mars3)
            marsAdj()
        }
    }

    private fun updateCounter(count: Long) {
        numCounter = count
        counterText.text = numCounter.toString() + " Gallons"
    }

    private fun updateLocation(location: Int) {
        if (location == 0) {
            clickerButton.setImageResource(R.drawable.earth)
            locationText.text = "Earth"
        }
        else if (location == 1) {
            clickerButton.setImageResource(R.drawable.mars3)
            marsAdj()
        }
    }

    private fun marsAdj() {
        locationText.text = "Mars"
        clickerButton.layoutParams.height = 500
        clickerButton.layoutParams.width = 500
        centerButton.visibility = View.INVISIBLE
    }

    private fun checkCounter(count: Long) {
        if (count >= 9 && locationNum == 1) {
            centerButton.text = "Travel to Mars"
            centerButton.visibility = View.VISIBLE
        }
    }
}
