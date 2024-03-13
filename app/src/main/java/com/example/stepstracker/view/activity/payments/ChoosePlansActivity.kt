package com.example.stepstracker.view.activity.payments

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.stepstracker.R
import com.example.stepstracker.databinding.ActivityChoosePlansBinding
import com.example.stepstracker.util.statusBarColorGrey

class ChoosePlansActivity : AppCompatActivity() {

    private lateinit var binding : ActivityChoosePlansBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChoosePlansBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusBarColorGrey()



    }
}