package com.example.stepstracker.view.activity

import android.content.SharedPreferences
import android.os.Bundle
import android.text.InputType
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.example.stepstracker.R
import com.example.stepstracker.databinding.ActivityLoginBinding
import com.example.stepstracker.util.intentFinish
import com.example.stepstracker.util.statusBarColorWhite
import com.example.stepstracker.util.toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth : FirebaseAuth
    private val database = Firebase.database
    private val myRef = database.getReference("Users")
    private lateinit var sharedPref: SharedPreferences
    private lateinit var editor : SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusBarColorWhite()

        auth = Firebase.auth
        sharedPref = getSharedPreferences("Login", MODE_PRIVATE)
        editor = sharedPref.edit()

        binding.apply {

            buttonClicks()

        }

    }

    private fun ActivityLoginBinding.buttonClicks() {
        btLogin.setOnClickListener {

            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                toast("Enter all field")
            } else {
                loginAccountUsingEmail(email, password)
            }
        }
        var count = 0
        val customFont = ResourcesCompat.getFont(this@LoginActivity, R.font.apompadour_text_sample)
        ivShow.setOnClickListener {
            val cursorPosition = etPassword.selectionStart
            if (count == 0) {
                etPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                etPassword.typeface = customFont
                ivShow.setImageResource(R.drawable.ic_pass_show)
                count = 1
            } else {
                etPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                etPassword.typeface = customFont
                ivShow.setImageResource(R.drawable.ic_pass_hide)
                count = 0
            }
            etPassword.setSelection(cursorPosition)
        }


        ivBack.setOnClickListener {
            finish()
        }
        tvSignUp.setOnClickListener {
            intentFinish(SignupActivity::class.java)
        }
    }

    private fun loginAccountUsingEmail(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this@LoginActivity) {

                if (it.isSuccessful) {

                    val uid = auth.currentUser?.uid.toString()

                    editor.putString("Useruid",uid)
                    editor.apply()

                    intentFinish(MainActivity::class.java)
                    finishAffinity()

                } else {
                    toast("No Account Found")
                }

            }.addOnFailureListener(this@LoginActivity) {
//                toast("Error: ${it.message}")
            }
    }

}