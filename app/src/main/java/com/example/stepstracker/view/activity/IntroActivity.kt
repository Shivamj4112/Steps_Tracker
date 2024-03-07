package com.example.stepstracker.view.activity

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.stepstracker.adapter.IntroViewPager
import com.example.stepstracker.databinding.ActivityIntroBinding
import com.example.stepstracker.util.intentFinish
import com.example.stepstracker.util.setSystemBarsAppearance

class IntroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntroBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSystemBarsAppearance()

        sharedPreferences = getSharedPreferences("Intro", MODE_PRIVATE)
        editor = sharedPreferences.edit()

        if (sharedPreferences.contains("isOldUser")) {
            intentFinish(LoginSelectionActivity::class.java)
        }


        binding.apply {

            viewPager.adapter = IntroViewPager(supportFragmentManager)
            dotsIndicator.setViewPager(viewPager)


            btSkip.setOnClickListener {
                viewPager.currentItem = viewPager.adapter?.count?.minus(1) ?: 0
            }
            btContinue.setOnClickListener {

                if (viewPager.currentItem < (viewPager.adapter?.count?.minus(1) ?: 0)) {
                    viewPager.currentItem += 1
                }
            }

            viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageScrollStateChanged(state: Int) {}

                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                }

                override fun onPageSelected(position: Int) {
                    // Toggle visibility of btMain based on the current page
                    if (position == (viewPager.adapter?.count?.minus(1) ?: 0)) {
                        binding.btMain.visibility = View.VISIBLE
                        binding.bottom.visibility = View.INVISIBLE

                        btMain.setOnClickListener {

                            editor.putBoolean("isOldUser", true)
                            editor.apply()

                            intentFinish(LoginSelectionActivity::class.java)
                        }

                    } else {
                        binding.btMain.visibility = View.GONE
                        binding.bottom.visibility = View.VISIBLE
                    }
                }
            })


        }

    }
}