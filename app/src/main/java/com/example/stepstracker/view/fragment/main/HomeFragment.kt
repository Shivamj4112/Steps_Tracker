package com.example.stepstracker.view.fragment.main

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.stepstracker.databinding.FragmentHomeBinding
import com.example.stepstracker.model.StepCounterViewModel

class HomeFragment : Fragment() , SensorEventListener {

    private var sensorManager: SensorManager? = null
    private var running = false
    private var totalSteps = 0f
    private var previousTotalSteps = 0f
    private lateinit var model : StepCounterViewModel
    private lateinit var binding : FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)

        model = ViewModelProvider(requireActivity())[StepCounterViewModel::class.java]
        model.totalSteps.observe(viewLifecycleOwner) { steps ->
            binding.tvStepCounter.text = steps.toInt().toString()

            val maxSteps = 6000
            val progress = ((steps.toFloat() / maxSteps) * 100).toInt()
            binding.asbProgressBar.progress = progress
            binding.asbProgressBar.max = 100
        }
        sensorManager = requireContext().getSystemService(Context.SENSOR_SERVICE) as SensorManager

        return binding.root
    }


    override fun onResume() {
        super.onResume()
        running = true
        val stepSensor = sensorManager?.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR)

        if (stepSensor == null) {
            Toast.makeText(requireContext(), "No sensor detected on this device", Toast.LENGTH_SHORT).show()
        } else {
            sensorManager?.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_FASTEST)
        }
    }

    override fun onPause() {
        super.onPause()
        running = false
    }

    override fun onSensorChanged(event: SensorEvent?) {

        if (running) {
            totalSteps = event!!.values[0]

            val currentSteps = totalSteps.toInt() - previousTotalSteps.toInt()
            model.setTotalSteps(currentSteps.toFloat())
//            binding.tvStepCounter.text = ("$currentSteps")
//            binding.asbProgressBar.progress = currentSteps
//            binding.asbProgressBar.max = 6000

            val maxSteps = 6000
            val progress = ((currentSteps.toFloat() / maxSteps) * 100).toInt()
            binding.asbProgressBar.progress = progress
            binding.asbProgressBar.max = 100
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        // We do not have to write anything in this function for this app
    }
}