package com.example.stepstracker.view.fragment.userDetail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.stepstracker.databinding.FragmentAgeBinding
import com.example.stepstracker.model.UserDetailModel
import com.example.stepstracker.util.toast
import com.shawnlin.numberpicker.NumberPicker
import java.util.Locale


class AgeFragment : Fragment() {

    private lateinit var binding : FragmentAgeBinding
    private val model : UserDetailModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAgeBinding.inflate(layoutInflater)

        binding.apply {

            model.age = numberPicker.value.toString()

            numberPicker.setOnScrollListener { picker, scrollState ->
                if (scrollState == NumberPicker.OnScrollListener.SCROLL_STATE_IDLE) {
                    model.age =  picker.value.toString()
                }
            }
        }


        return binding.root
    }

}