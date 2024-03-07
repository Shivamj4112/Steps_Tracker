package com.example.stepstracker.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class userDetailModel : ViewModel(){

    val gender = MutableLiveData<String>()
    val sedentary = MutableLiveData<String>()
}
