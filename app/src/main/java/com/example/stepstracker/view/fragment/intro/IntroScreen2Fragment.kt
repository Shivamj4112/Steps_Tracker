package com.example.stepstracker.view.fragment.intro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.stepstracker.databinding.FragmentIntroScreen2Binding


class IntroScreen2Fragment : Fragment() {

    private lateinit var binding: FragmentIntroScreen2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentIntroScreen2Binding.inflate(inflater, container, false)











        return binding.root
    }

}