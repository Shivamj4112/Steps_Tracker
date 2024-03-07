package com.example.stepstracker.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.stepstracker.view.fragment.intro.IntroScreen1Fragment
import com.example.stepstracker.view.fragment.intro.IntroScreen2Fragment
import com.example.stepstracker.view.fragment.intro.IntroScreen3Fragment
import com.example.stepstracker.view.fragment.userDetail.GenderFragment
import com.example.stepstracker.view.fragment.userDetail.SedentaryFragment

class DetailViewPager(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 6 // Adjust the count according to your requirement
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> GenderFragment()
            1 -> SedentaryFragment()
            // Add cases for other fragments
            else -> GenderFragment() // Default case
        }
    }
}