package com.example.stepstracker.view.fragment.userDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.stepstracker.R
import com.example.stepstracker.databinding.FragmentGenderBinding


class GenderFragment : Fragment() {

    private lateinit var binding : FragmentGenderBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentGenderBinding.inflate(layoutInflater)






        return binding.root
    }
}