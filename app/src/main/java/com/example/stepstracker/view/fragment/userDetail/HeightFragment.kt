package com.example.stepstracker.view.fragment.userDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.stepstracker.R
import com.example.stepstracker.databinding.FragmentHeightBinding
import com.example.stepstracker.model.UserDetailModel
import com.example.stepstracker.util.gone
import com.example.stepstracker.util.toast
import com.example.stepstracker.util.visible
import com.shawnlin.numberpicker.NumberPicker

class HeightFragment : Fragment() {

    private lateinit var binding : FragmentHeightBinding
    private val model : UserDetailModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHeightBinding.inflate(layoutInflater)

        binding.apply {

            model.age = npCm.value.toString() + " cm"

            btCm.setOnClickListener {

                btCm.setTextColor(resources.getColor(R.color.white))
                btCm.setBackgroundColor(resources.getColor(R.color.app_color))

                btFt.setTextColor(resources.getColor(R.color.black))
                btFt.setBackgroundColor(resources.getColor(R.color.lightest_app_color))

                llCm.visible()
                llFeet.gone()

                model.age = npCm.value.toString() + " cm"

            }

            btFt.setOnClickListener {

                btFt.setTextColor(resources.getColor(R.color.white))
                btFt.setBackgroundColor(resources.getColor(R.color.app_color))

                btCm.setTextColor(resources.getColor(R.color.black))
                btCm.setBackgroundColor(resources.getColor(R.color.lightest_app_color))

                llFeet.visible()
                llCm.gone()

                model.age = npFt.value.toString() + " ft"

            }

            npCm.setOnScrollListener { picker, scrollState ->
                if (scrollState == NumberPicker.OnScrollListener.SCROLL_STATE_IDLE) {

                    model.age = npCm.value.toString() + " cm"
                }
            }

            npFt.setOnScrollListener { picker, scrollState ->
                if (scrollState == NumberPicker.OnScrollListener.SCROLL_STATE_IDLE) {
                    model.age = npFt.value.toString() + " ft"
                }
            }


        }


        return binding.root
    }
}