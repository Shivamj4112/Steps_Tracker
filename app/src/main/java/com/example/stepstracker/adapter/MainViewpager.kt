package com.example.stepstracker.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.stepstracker.view.fragment.main.AccountFragment
import com.example.stepstracker.view.fragment.main.HistoryFragment
import com.example.stepstracker.view.fragment.main.HomeFragment
import com.example.stepstracker.view.fragment.main.ReportFragment
import com.example.stepstracker.view.fragment.main.TrackFragment

class MainViewpager(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 5
    }

    override fun getItem(position: Int): Fragment {

        when(position){

            0 -> return HomeFragment()
            1 -> return TrackFragment()
            2 -> return ReportFragment()
            3 -> return HistoryFragment()
            4 -> return AccountFragment()
            else -> return HomeFragment()
        }
    }
}