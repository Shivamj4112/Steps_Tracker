package com.example.stepstracker.view.activity

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.WindowManager
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.stepstracker.R
import com.example.stepstracker.adapter.DetailViewPager
import com.example.stepstracker.databinding.ActivityUserDetailBinding
import com.example.stepstracker.model.UserDetailModel
import com.example.stepstracker.util.statusBarColorWhite
import com.example.stepstracker.util.toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class UserDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserDetailBinding
    private val model: UserDetailModel by viewModels()
    private lateinit var sharedPref: SharedPreferences
    private lateinit var auth: FirebaseAuth
    private val database = Firebase.database
    private val myRef = database.getReference("Users")
    private lateinit var editor: SharedPreferences.Editor
    private lateinit var name: String
    private lateinit var email: String
    private lateinit var password: String
    private lateinit var dialog : Dialog

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusBarColorWhite()

        auth = Firebase.auth
        sharedPref = getSharedPreferences("UserDetail", MODE_PRIVATE)
        editor = sharedPref.edit()

        dialogAccountCreated()


        val sharedCredential = getSharedPreferences("Signup", MODE_PRIVATE)
        name = sharedCredential.getString("name", "").toString()
        email = sharedCredential.getString("email", "").toString()
        password = sharedCredential.getString("password", "").toString()


        binding.apply {

            userPager.adapter = DetailViewPager(this@UserDetailActivity)
            userPager.setUserInputEnabled(false)

            btPrevious.setOnClickListener {
                if (userPager.currentItem > 0) {
                    userPager.currentItem -= 1
                    tvNumIndicator.text = ("" + (userPager.currentItem + 1) + " / 6")
                }
            }
            btContinue.setOnClickListener {

                val currentItem = userPager.currentItem
                val isLastPage = currentItem == (userPager.adapter?.itemCount?.minus(1) ?: 0)

                val dataMissing = when (currentItem) {
                    0 -> model.gender.isEmpty()
                    1 -> model.sedentary.isEmpty()
                    2 -> model.age.isEmpty()
                    3 -> model.height.isEmpty()
                    4 -> model.weight.isEmpty()
                    5 -> model.step.isEmpty()

                    else -> false
                }

                if (!isLastPage && !dataMissing) {
                    userPager.currentItem += 1
                    tvNumIndicator.text = "${userPager.currentItem + 1} / 6"
                } else if (isLastPage) {

                    toast("Your are Done!")

                    createAccountUsingEmail()

                } else {
                    checkDataEmpty()
                }
            }
        }
    }

    private fun createAccountUsingEmail(){

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this@UserDetailActivity) {

                if (it.isSuccessful) {

                    val uid = auth.currentUser?.uid.toString()

                    val userRef = myRef.child(uid).child("profile")
                    userRef.child("name").setValue(name)
                    userRef.child("email").setValue(email)

                    addDataToDatabase(userRef)
                }


            }.addOnFailureListener(this@UserDetailActivity) {

            }
    }
    private fun addDataToDatabase(userRef: DatabaseReference) {

        userRef.child("gender").setValue(model.gender)
        userRef.child("sedentary").setValue(model.sedentary)
        userRef.child("age").setValue(model.age)
        userRef.child("height").setValue(model.height)
        userRef.child("weight").setValue(model.weight)
        userRef.child("step").setValue(model.step)

        dialog.show()

        Handler().postDelayed(Runnable {

            dialog.dismiss()

            val intent = Intent(this@UserDetailActivity, LoginActivity::class.java)
            intent.putExtra("finalLogin", true)
            startActivity(intent)
            finish()
            finishAffinity()

            editor.putBoolean("idDetailFilled", true)
            editor.apply()

        },3000)

    }
    private fun checkDataEmpty() {
        if (model.gender.isEmpty()) {
            Toast.makeText(this@UserDetailActivity, "Select Gender", Toast.LENGTH_SHORT)
                .show()
        } else if (model.sedentary.isEmpty()) {
            Toast.makeText(
                this@UserDetailActivity,
                "Select Yes ot No",
                Toast.LENGTH_SHORT
            ).show()
        } else if (model.age.isEmpty()) {
            Toast.makeText(
                this@UserDetailActivity,
                "Select Your Age",
                Toast.LENGTH_SHORT
            ).show()
        } else if (model.height.isEmpty()) {
            Toast.makeText(
                this@UserDetailActivity,
                "Select Your Height",
                Toast.LENGTH_SHORT
            ).show()
        } else if (model.weight.isEmpty()) {
            Toast.makeText(
                this@UserDetailActivity,
                "Select Your Weight",
                Toast.LENGTH_SHORT
            ).show()
        } else if (model.step.isEmpty()) {
            Toast.makeText(
                this@UserDetailActivity,
                "Select Your Step",
                Toast.LENGTH_SHORT
            ).show()
        }
    }


    private fun dialogAccountCreated() {

        dialog = Dialog(this)
        dialog.setCancelable(true)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setContentView(R.layout.dialog_account_created)

        val lp = WindowManager.LayoutParams()
        lp.copyFrom(dialog.window!!.attributes)
        lp.width = WindowManager.LayoutParams.MATCH_PARENT
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT
        lp.gravity = Gravity.CENTER

        dialog.window!!.attributes = lp


    }
}