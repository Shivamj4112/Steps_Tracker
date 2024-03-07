package com.example.stepstracker.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.stepstracker.databinding.FragmentIntroScreen1Binding

class IntroScreen1Fragment : Fragment() {
    
    private lateinit var binding: FragmentIntroScreen1Binding
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentIntroScreen1Binding.inflate(inflater, container, false)











        return binding.root
    }
    
}