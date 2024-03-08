package com.example.stepstracker.view.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.stepstracker.adapter.DetailViewPager
import com.example.stepstracker.databinding.ActivityUserDetailBinding
import com.example.stepstracker.model.UserDetailModel
import com.example.stepstracker.util.statusBarColorWhite

class UserDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserDetailBinding
    private val model: UserDetailModel by viewModels()
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusBarColorWhite()


        binding.apply {

            userPager.adapter = DetailViewPager(this@UserDetailActivity)
            userPager.setUserInputEnabled(false)


            btBack.setOnClickListener {
                finish()
            }

            btPrevious.setOnClickListener {
                if (userPager.currentItem > 0) {
                    userPager.currentItem -= 1
                    tvNumIndicator.text = (""+(userPager.currentItem+1)+" / 6")
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

                    Toast.makeText(this@UserDetailActivity, model.gender, Toast.LENGTH_SHORT).show()
                } else {
                    checkDataEmpty()
                }

//                if (model.gender.isNotEmpty()) {
//                    val isLastPage = userPager.currentItem == (userPager.adapter?.itemCount?.minus(1) ?: 0)
//                    if (!isLastPage) {
//                        userPager.currentItem += 1
//                        tvNumIndicator.text = "${userPager.currentItem + 1} / 6"
//                    } else {
//                        Toast.makeText(this@UserDetailActivity, "Your are Ready Now.", Toast.LENGTH_SHORT).show()
//                    }
//                } else {
//                    Toast.makeText(this@UserDetailActivity, "Please select gender", Toast.LENGTH_SHORT).show()
//                }
            }

        }

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
}