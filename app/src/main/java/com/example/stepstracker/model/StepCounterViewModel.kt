package com.example.stepstracker.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class StepCounterViewModel : ViewModel() {
    private val _totalSteps = MutableLiveData<Float>()
    val totalSteps: LiveData<Float>
        get() = _totalSteps

    fun setTotalSteps(steps: Float) {
        _totalSteps.value = steps
    }
}
