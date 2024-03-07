package com.example.stepstracker.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.stepstracker.view.fragment.intro.IntroScreen1Fragment
import com.example.stepstracker.view.fragment.intro.IntroScreen2Fragment
import com.example.stepstracker.view.fragment.intro.IntroScreen3Fragment

class IntroViewPager(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return when(position){

            0 ->{
                IntroScreen1Fragment()
            }

            1 ->{
                IntroScreen2Fragment()
            }

            else ->{
                IntroScreen3Fragment()
            }
        }

    }

}