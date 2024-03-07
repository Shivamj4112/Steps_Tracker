package com.example.stepstracker.view.fragment.userDetail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.stepstracker.R
import com.example.stepstracker.databinding.FragmentGenderBinding
import com.example.stepstracker.model.userDetailModel


class GenderFragment : Fragment() {

    private lateinit var binding : FragmentGenderBinding
    private lateinit var viewDetailModel: userDetailModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentGenderBinding.inflate(layoutInflater)


        binding.apply {

            mcvMale.setOnClickListener {
                mcvMale.strokeWidth = 7
                mcvMale.strokeColor = ContextCompat.getColor(requireContext(), R.color.app_color)
                mcvFemale.strokeWidth = 0

                viewDetailModel.gender.value = "Male"
            }

            mcvFemale.setOnClickListener {
                mcvFemale.strokeWidth = 7
                mcvFemale.strokeColor = ContextCompat.getColor(requireContext(), R.color.app_color)
                mcvMale.strokeWidth = 0
                viewDetailModel.gender.value = "Female"
            }

        }


        return binding.root
    }
}