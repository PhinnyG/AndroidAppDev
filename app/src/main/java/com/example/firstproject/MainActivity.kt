package com.example.firstproject

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var numCounter: Long = 0
    fun dataStore() = getPreferences(Context.MODE_PRIVATE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val user = intent.extras?.get("username").toString()
        numCounter = dataStore().getLong(user, numCounter)
        counterText.text = "$" + numCounter.toString()

        if (savedInstanceState != null) {
            numCounter = savedInstanceState.getLong(user)
            counterText.text = "$" + numCounter.toString()
        }

        button.setOnClickListener {
            numCounter++
            counterText.text = "$" + numCounter.toString()
        }
    }

    override fun onPause() {
        super.onPause()
        dataStore().edit().putLong(intent.extras?.get("username").toString(), numCounter).apply()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            putLong(intent.extras?.get("username").toString(), numCounter)
        }
        super.onSaveInstanceState(outState)
    }
}
