package com.example.firstproject

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.example.firstproject.util.toggleVisibility
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var numCounter: Long = 0
    fun dataStore() = getPreferences(Context.MODE_PRIVATE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numCounter = dataStore().getLong(NUM_COUNTER_STATE, numCounter)
        counterText.text = numCounter.toString()

        if (savedInstanceState != null) {
            numCounter = savedInstanceState.getLong(NUM_COUNTER_STATE)
            counterText.text = numCounter.toString()
        }

        button.setOnClickListener {
            numCounter++
            counterText.text = numCounter.toString()
        }
    }

    override fun onPause() {
        super.onPause()
        dataStore().edit().putLong(NUM_COUNTER_STATE, numCounter).apply()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.run {
            putLong(NUM_COUNTER_STATE, numCounter)
        }
        super.onSaveInstanceState(outState)
    }

    companion object {
        private const val NUM_COUNTER_STATE = "numCounterState"
    }
}
