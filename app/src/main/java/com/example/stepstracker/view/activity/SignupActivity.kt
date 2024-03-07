package com.example.stepstracker.view.activity

import android.graphics.Typeface
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.example.stepstracker.R
import com.example.stepstracker.databinding.ActivitySignupBinding
import com.example.stepstracker.util.intentFinish
import com.example.stepstracker.util.statusBarColorWhite
import com.example.stepstracker.util.toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var auth : FirebaseAuth
    private val database = Firebase.database
    private val myRef = database.getReference("Users")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusBarColorWhite()

        auth = Firebase.auth

        binding.apply {

            buttonSignup()
            otherCLicks()

        }

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
                createAccountUsingEmail(email, password, name)
            }

        }
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

    private fun createAccountUsingEmail(email: String, password: String, name: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this@SignupActivity) {

                if (it.isSuccessful) {

                    val uid = auth.currentUser?.uid.toString()
                    val userRef = myRef.child(uid)

                    userRef.child("name").setValue(name)
                    userRef.child("email").setValue(email)

                    intentFinish(LoginActivity::class.java)

                } else {
                    toast("Failed to create user")
                }

            }.addOnFailureListener(this@SignupActivity) {
                toast("Error: ${it.message}")
            }
    }

}