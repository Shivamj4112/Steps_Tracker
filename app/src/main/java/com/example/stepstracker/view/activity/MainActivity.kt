package com.example.stepstracker.view.activity

import android.Manifest
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.stepstracker.databinding.ActivityMainBinding
import com.example.stepstracker.util.statusBarColorGrey
import com.example.stepstracker.view.fragment.main.HomeFragment
import io.ak1.OnBubbleClickListener

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusBarColorGrey()

        requestPermission()

        binding.bubbleTabBar.addBubbleListener(object : OnBubbleClickListener{
            override fun onBubbleClick(id: Int) {

                when(id){
                    0 -> HomeFragment()
                    1 -> HomeFragment()
                    2 -> HomeFragment()
                    3 -> HomeFragment()
                    4 -> HomeFragment()
                }

            }
        })

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

