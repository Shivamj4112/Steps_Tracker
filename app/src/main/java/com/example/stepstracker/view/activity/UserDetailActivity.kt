package com.example.stepstracker.view.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.stepstracker.R
import com.example.stepstracker.adapter.DetailViewPager
import com.example.stepstracker.adapter.IntroViewPager
import com.example.stepstracker.databinding.ActivityUserDetailBinding
import com.example.stepstracker.util.setSystemBarsAppearance
import com.example.stepstracker.util.statusBarColorWhite

class UserDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusBarColorWhite()

        binding.apply {

            userPager.adapter = DetailViewPager(this@UserDetailActivity)
            userPager.setUserInputEnabled(false)

            btBack.setOnClickListener {
                if (userPager.currentItem > 0) {
                    userPager.currentItem -= 1
                }
            }
            btContinue.setOnClickListener {

                if (userPager.currentItem < (userPager.adapter?.itemCount?.minus(1) ?: 0)) {
                    userPager.currentItem += 1
                }
            }

        }

    }
}