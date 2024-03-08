package com.example.stepstracker.view.fragment.userDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.stepstracker.R
import com.example.stepstracker.databinding.FragmentGoalsBinding
import com.example.stepstracker.model.UserDetailModel
import com.shawnlin.numberpicker.NumberPicker

class GoalsFragment : Fragment() {

    private lateinit var binding: FragmentGoalsBinding
    private val model: UserDetailModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentGoalsBinding.inflate(layoutInflater)

        binding.apply {

            val step = (1000..10000 step 500).map { it.toString() }.toTypedArray()


            npSteps.maxValue = step.size
            npSteps.displayedValues = step
            npSteps.value = 11
            npSteps.wrapSelectorWheel = false

            model.step = step[(npSteps.value - 1)] + " step"


            npSteps.setOnScrollListener { picker, scrollState ->
                if (scrollState == NumberPicker.OnScrollListener.SCROLL_STATE_IDLE) {
                    model.step = step[(picker.value - 1)] + " step"
                }
            }

        }

        return binding.root
    }


}