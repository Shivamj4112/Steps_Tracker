package com.example.stepstracker.view.fragment.userDetail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.stepstracker.databinding.FragmentAgeBinding
import com.shawnlin.numberpicker.NumberPicker
import java.util.Locale


class AgeFragment : Fragment() {

    private lateinit var binding : FragmentAgeBinding
    private val dividerValue = 28

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAgeBinding.inflate(layoutInflater)

        binding.apply {

//            var previousValue = -1 // Variable to store the previous value
//
//            numberPicker.setOnValueChangedListener { picker, oldVal, newVal ->
//                if (newVal != previousValue) {
//                    // Only handle the callback if the new value is different from the previous value
//                    Toast.makeText(requireContext(), newVal.toString(), Toast.LENGTH_SHORT).show()
//                    previousValue = newVal // Update the previous value
//                }
//            }
            numberPicker.setOnScrollListener { picker, scrollState ->
                if (scrollState == NumberPicker.OnScrollListener.SCROLL_STATE_IDLE) {
                    Toast.makeText(requireContext(), picker.value.toString(), Toast.LENGTH_SHORT).show()
                }
            }

        }


        return binding.root
    }

}