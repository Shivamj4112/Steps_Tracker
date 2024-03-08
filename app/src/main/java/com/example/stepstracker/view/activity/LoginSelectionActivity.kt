package com.example.stepstracker.view.activity

import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.annotation.ColorRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.stepstracker.R
import com.example.stepstracker.databinding.ActivityLoginSelectionBinding
import com.example.stepstracker.util.intent
import com.example.stepstracker.util.intentFinish
import com.example.stepstracker.util.setSystemBarsAppearance
import com.example.stepstracker.util.statusBarColorWhite

class LoginSelectionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginSelectionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginSelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        statusBarColorWhite()

        val sharedPreferencesLogin: SharedPreferences = getSharedPreferences("Login", MODE_PRIVATE)
        val sharedPreferencesSignUp: SharedPreferences = getSharedPreferences("Signup", MODE_PRIVATE)
        val sharedPreferencesDetail: SharedPreferences = getSharedPreferences("UserDetail", MODE_PRIVATE)


        if (sharedPreferencesLogin.contains("Useruid")) {
            intentFinish(MainActivity::class.java)
        }
        else if (sharedPreferencesDetail.contains("idDetailFilled")){
            intentFinish(LoginActivity::class.java)
        }
        else if (sharedPreferencesSignUp.contains("isAccountCreated")) {
            intentFinish(UserDetailActivity::class.java)
        }



        binding.apply {

            btSignup.setOnClickListener {
                intent(SignupActivity::class.java)
            }

            btLogin.setOnClickListener {
                intent(LoginActivity::class.java)
            }


        }


    }
}