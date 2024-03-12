package com.example.stepstracker.view.activity.auth

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.stepstracker.databinding.ActivityLoginSelectionBinding
import com.example.stepstracker.util.intent
import com.example.stepstracker.util.intentFinish
import com.example.stepstracker.util.statusBarColorWhite
import com.example.stepstracker.view.activity.MainActivity
import com.example.stepstracker.view.activity.intro.UserDetailActivity

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