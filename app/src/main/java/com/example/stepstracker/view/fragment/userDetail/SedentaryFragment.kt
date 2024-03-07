package com.example.stepstracker.view.fragment.userDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.stepstracker.R
import com.example.stepstracker.databinding.FragmentSedentaryBinding

class SedentaryFragment : Fragment() {

    private lateinit var binding : FragmentSedentaryBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSedentaryBinding.inflate(layoutInflater)

        binding.apply {

            btYes.setOnClickListener {

                btYes.setTextColor(resources.getColor(R.color.white))
                btYes.setBackgroundColor(resources.getColor(R.color.app_color))

                btNo.setTextColor(resources.getColor(R.color.black))
                btNo.setBackgroundColor(resources.getColor(R.color.lightest_app_color))
            }

            btNo.setOnClickListener {

                btNo.setTextColor(resources.getColor(R.color.white))
                btNo.setBackgroundColor(resources.getColor(R.color.app_color))

                btYes.setTextColor(resources.getColor(R.color.black))
                btYes.setBackgroundColor(resources.getColor(R.color.lightest_app_color))
            }

        }

        return binding.root
    }

}