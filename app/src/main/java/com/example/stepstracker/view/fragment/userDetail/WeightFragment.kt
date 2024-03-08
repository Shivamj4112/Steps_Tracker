package com.example.stepstracker.view.fragment.userDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.stepstracker.R
import com.example.stepstracker.databinding.FragmentWeightBinding
import com.example.stepstracker.model.UserDetailModel
import com.example.stepstracker.util.gone
import com.example.stepstracker.util.visible
import com.shawnlin.numberpicker.NumberPicker

class WeightFragment : Fragment() {

    private lateinit var binding : FragmentWeightBinding
    private val model : UserDetailModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentWeightBinding.inflate(layoutInflater)

        binding.apply {

            model.weight = npKg.value.toString() + " kg"

            btKg.setOnClickListener {


                btKg.setTextColor(resources.getColor(R.color.white))
                btKg.setBackgroundColor(resources.getColor(R.color.app_color))

                btLbs.setTextColor(resources.getColor(R.color.black))
                btLbs.setBackgroundColor(resources.getColor(R.color.lightest_app_color))

                llKg.visible()
                llLbs.gone()

                model.weight = npKg.value.toString() + " kg"
            }

            btLbs.setOnClickListener {

                btLbs.setTextColor(resources.getColor(R.color.white))
                btLbs.setBackgroundColor(resources.getColor(R.color.app_color))

                btKg.setTextColor(resources.getColor(R.color.black))
                btKg.setBackgroundColor(resources.getColor(R.color.lightest_app_color))

                llLbs.visible()
                llKg.gone()

                model.weight = npKg.value.toString() + " lbs"
            }

            npKg.setOnScrollListener { picker, scrollState ->
                if (scrollState == NumberPicker.OnScrollListener.SCROLL_STATE_IDLE) {

                    model.weight = npKg.value.toString() + " kg"
                }
            }

            npLbs.setOnScrollListener { picker, scrollState ->
                if (scrollState == NumberPicker.OnScrollListener.SCROLL_STATE_IDLE) {
                    model.weight = npLbs.value.toString() + " lbs"
                }
            }


        }
        return binding.root
    }

}