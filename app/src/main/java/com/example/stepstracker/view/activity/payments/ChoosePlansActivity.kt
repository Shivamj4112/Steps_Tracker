package com.example.stepstracker.view.activity.payments

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.stepstracker.R
import com.example.stepstracker.util.statusBarColorGrey

class ChoosePlansActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_plans)
        statusBarColorGrey()



    }
}