package com.example.stepstracker.view.activity.auth

import android.content.SharedPreferences
import android.os.Bundle
import android.text.InputType
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.example.stepstracker.R
import com.example.stepstracker.databinding.ActivitySignupBinding
import com.example.stepstracker.util.intentFinish
import com.example.stepstracker.util.statusBarColorWhite
import com.example.stepstracker.util.toast
import com.example.stepstracker.view.activity.intro.UserDetailActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var sharedPref: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusBarColorWhite()

        initialization()

        binding.apply {

            buttonSignup()
            otherCLicks()
        }
    }

    private fun initialization() {
        auth = Firebase.auth
        sharedPref = getSharedPreferences("Signup", MODE_PRIVATE)
        editor = sharedPref.edit()
    }
    private fun ActivitySignupBinding.otherCLicks() {
        ivBack.setOnClickListener {
            finish()
        }
        tvLogin.setOnClickListener {
            intentFinish(LoginActivity::class.java)
        }
    }
    private fun ActivitySignupBinding.buttonSignup() {
        btSignup.setOnClickListener {

            val name = etName.text.toString()
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                toast("Enter all field")
            } else if (!cbTerms.isChecked) {
                toast("Please check the Terms and Conditions to proceed")
            } else {
                sendData(email, password, name)
            }

        }
        passwordHideShow()
    }
    private fun ActivitySignupBinding.passwordHideShow() {
        var count = 0
        val customFont = ResourcesCompat.getFont(this@SignupActivity, R.font.apompadour_text_sample)
        ivPassShow.setOnClickListener {
            val cursorPosition = etPassword.selectionStart
            if (count == 0) {
                etPassword.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                etPassword.typeface = customFont
                ivPassShow.setImageResource(R.drawable.ic_pass_show)
                count = 1
            } else {
                etPassword.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                etPassword.typeface = customFont
                ivPassShow.setImageResource(R.drawable.ic_pass_hide)
                count = 0
            }
            etPassword.setSelection(cursorPosition)
        }
    }
    private fun sendData(email: String, password: String, name: String) {

        intentFinish(UserDetailActivity::class.java)
        finishAffinity()

        editor.putString("name", name)
        editor.putString("email", email)
        editor.putString("password", password)
        editor.putBoolean("isAccountCreated", true)
        editor.apply()
    }


}