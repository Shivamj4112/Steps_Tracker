package com.example.stepstracker.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.View
import android.view.WindowInsetsController
import android.widget.Toast
import com.example.stepstracker.R
import com.example.stepstracker.view.activity.MainActivity


fun View.gone() {
    visibility = View.GONE
}
fun View.visible() {
    visibility = View.VISIBLE
}
fun Activity.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Activity.setSystemBarsAppearance() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        this.window.decorView.windowInsetsController?.setSystemBarsAppearance(
            0, WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
        )
    }
}

fun Activity.statusBarColorWhite() {
    window.statusBarColor = getColor(R.color.bg_white)
}

fun Activity.intentFinish(context: Class<*>) {
    startActivity(Intent(this@intentFinish, context))
    finish()
}

fun Activity.intent(context: Class<*>) {
    startActivity(Intent(this@intent, context))
}