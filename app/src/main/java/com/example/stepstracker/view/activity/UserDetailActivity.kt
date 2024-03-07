package com.example.stepstracker.view.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.stepstracker.R
import com.example.stepstracker.databinding.ActivityUserDetailBinding

class UserDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {


        }

    }
}