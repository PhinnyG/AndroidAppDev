package com.example.firstproject.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firstproject.R
import kotlinx.android.synthetic.main.activity_login_screen.*

class LoginScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        LoginButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java).apply { putExtra("username", LoginField.text) })
        }

    }
}
