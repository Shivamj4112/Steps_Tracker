package com.example.stepstracker.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.stepstracker.databinding.FragmentIntroScreen3Binding


class IntroScreen3Fragment : Fragment() {
    private lateinit var binding: FragmentIntroScreen3Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentIntroScreen3Binding.inflate(inflater, container, false)











        return binding.root
    }

}