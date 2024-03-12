package com.example.stepstracker.view.fragment.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.stepstracker.databinding.FragmentAccountBinding
import com.example.stepstracker.util.intent
import com.example.stepstracker.view.activity.payments.PlansActivity


class AccountFragment : Fragment() {

    private lateinit var binding : FragmentAccountBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAccountBinding.inflate(layoutInflater)

        binding.apply {

            llUpgradePlan.setOnClickListener {
                requireActivity().intent(PlansActivity::class.java)
            }
        }


        return binding.root
    }


}