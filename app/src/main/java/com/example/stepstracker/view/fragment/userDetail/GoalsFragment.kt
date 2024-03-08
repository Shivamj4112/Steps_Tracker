package com.example.stepstracker.view.fragment.userDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.stepstracker.R
import com.example.stepstracker.databinding.FragmentGenderBinding
import com.example.stepstracker.databinding.FragmentGoalsBinding

class GoalsFragment : Fragment() {

    private lateinit var binding : FragmentGoalsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentGoalsBinding.inflate(layoutInflater)

        binding.apply {
            val stepGoals = resources.getStringArray(R.array.stepsGoals)
            npSteps.maxValue = stepGoals.size
            npSteps.displayedValues = stepGoals
            npSteps.value = 11
            npSteps.wrapSelectorWheel = false

        }

        return binding.root
    }


}