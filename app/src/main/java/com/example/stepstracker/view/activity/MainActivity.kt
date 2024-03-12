package com.example.stepstracker.view.activity

import android.Manifest
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.stepstracker.R
import com.example.stepstracker.adapter.MainViewpager
import com.example.stepstracker.databinding.ActivityMainBinding
import com.example.stepstracker.util.statusBarColorGrey
import com.example.stepstracker.view.fragment.main.HomeFragment
import com.example.stepstracker.view.fragment.main.TrackFragment
import io.ak1.OnBubbleClickListener

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusBarColorGrey()

        requestPermission()

        binding.apply {

            viewPager.adapter = MainViewpager(supportFragmentManager)

            viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {

                }

                override fun onPageSelected(position: Int) {
                    bubbleTabBar.setSelected(position, false)
                }

                override fun onPageScrollStateChanged(state: Int) {
                }
            })

            bubbleTabBar.addBubbleListener { id ->
                when (id) {
                    R.id.home -> viewPager.currentItem = 0
                    R.id.location -> viewPager.currentItem = 1
                    R.id.report -> viewPager.currentItem = 2
                    R.id.history -> viewPager.currentItem = 3
                    R.id.account -> viewPager.currentItem = 4
                }
            }


        }


    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(
            this@MainActivity,
            arrayOf(
                Manifest.permission.ACTIVITY_RECOGNITION,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ),
            1
        )
    }

}

