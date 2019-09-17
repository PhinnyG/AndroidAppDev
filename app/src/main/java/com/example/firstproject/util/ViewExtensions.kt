package com.example.firstproject.util

import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

fun View.toggleVisibility() {
    if(visibility == View.VISIBLE) {
        visibility = View.INVISIBLE
    }
    else {
        visibility = View.VISIBLE
    }
}