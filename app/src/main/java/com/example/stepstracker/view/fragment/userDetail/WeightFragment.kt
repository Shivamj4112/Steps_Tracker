package com.example.stepstracker.view.fragment.userDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.stepstracker.R
import com.example.stepstracker.databinding.FragmentWeightBinding
import com.example.stepstracker.util.gone
import com.example.stepstracker.util.visible

class WeightFragment : Fragment() {

    private lateinit var binding : FragmentWeightBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWeightBinding.inflate(layoutInflater)

        binding.apply {

            btKg.setOnClickListener {

                btKg.setTextColor(resources.getColor(R.color.white))
                btKg.setBackgroundColor(resources.getColor(R.color.app_color))

                btLbs.setTextColor(resources.getColor(R.color.black))
                btLbs.setBackgroundColor(resources.getColor(R.color.lightest_app_color))

                llKg.visible()
                llLbs.gone()
            }

            btLbs.setOnClickListener {

                btLbs.setTextColor(resources.getColor(R.color.white))
                btLbs.setBackgroundColor(resources.getColor(R.color.app_color))

                btKg.setTextColor(resources.getColor(R.color.black))
                btKg.setBackgroundColor(resources.getColor(R.color.lightest_app_color))

                llLbs.visible()
                llKg.gone()

            }


        }
        return binding.root
    }

}