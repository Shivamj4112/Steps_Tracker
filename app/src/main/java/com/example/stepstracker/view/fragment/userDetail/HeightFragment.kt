package com.example.stepstracker.view.fragment.userDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.stepstracker.R
import com.example.stepstracker.databinding.FragmentHeightBinding
import com.example.stepstracker.util.gone
import com.example.stepstracker.util.visible

class HeightFragment : Fragment() {

    private lateinit var binding : FragmentHeightBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHeightBinding.inflate(layoutInflater)

        binding.apply {

            btCm.setOnClickListener {

                btCm.setTextColor(resources.getColor(R.color.white))
                btCm.setBackgroundColor(resources.getColor(R.color.app_color))

                btFt.setTextColor(resources.getColor(R.color.black))
                btFt.setBackgroundColor(resources.getColor(R.color.lightest_app_color))

                llCm.visible()
                llFeet.gone()
            }

            btFt.setOnClickListener {

                btFt.setTextColor(resources.getColor(R.color.white))
                btFt.setBackgroundColor(resources.getColor(R.color.app_color))

                btCm.setTextColor(resources.getColor(R.color.black))
                btCm.setBackgroundColor(resources.getColor(R.color.lightest_app_color))

                llFeet.visible()
                llCm.gone()

            }


        }


        return binding.root
    }
}