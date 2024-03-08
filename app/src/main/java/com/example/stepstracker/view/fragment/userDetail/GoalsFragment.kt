package com.example.stepstracker.view.fragment.userDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.stepstracker.R
import com.example.stepstracker.databinding.FragmentGenderBinding
import com.example.stepstracker.databinding.FragmentGoalsBinding
import com.example.stepstracker.model.UserDetailModel
import com.shawnlin.numberpicker.NumberPicker

class GoalsFragment : Fragment() {

    private lateinit var binding : FragmentGoalsBinding
    private val model : UserDetailModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentGoalsBinding.inflate(layoutInflater)

        binding.apply {

            model.step = npSteps.value.toString() + " step"

            val stepGoals = resources.getStringArray(R.array.stepsGoals)
            npSteps.maxValue = stepGoals.size
            npSteps.displayedValues = stepGoals
            npSteps.value = 11
            npSteps.wrapSelectorWheel = false

            npSteps.setOnScrollListener { picker, scrollState ->
                if (scrollState == NumberPicker.OnScrollListener.SCROLL_STATE_IDLE) {
                    model.step = picker.value.toString() + " step"
                }
            }

        }

        return binding.root
    }


}