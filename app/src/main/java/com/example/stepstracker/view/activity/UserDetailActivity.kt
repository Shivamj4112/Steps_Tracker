package com.example.stepstracker.view.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.stepstracker.R
import com.example.stepstracker.adapter.DetailViewPager
import com.example.stepstracker.adapter.IntroViewPager
import com.example.stepstracker.databinding.ActivityUserDetailBinding
import com.example.stepstracker.model.userDetailModel
import com.example.stepstracker.util.setSystemBarsAppearance
import com.example.stepstracker.util.statusBarColorWhite
import com.example.stepstracker.view.fragment.userDetail.AgeFragment
import com.example.stepstracker.view.fragment.userDetail.GenderFragment
import com.example.stepstracker.view.fragment.userDetail.SedentaryFragment

class UserDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserDetailBinding
    private lateinit var userDetailModel: userDetailModel
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusBarColorWhite()

//        userDetailModel = ViewModelProvider(this)[userDetailModel::class.java]

        binding.apply {

            userPager.adapter = DetailViewPager(this@UserDetailActivity)
            userPager.setUserInputEnabled(false)

//            val gender = GenderFragment()
//            val sedentary = SedentaryFragment()
//            val age = AgeFragment()
//            // Add other fragments similarly
//
//            // Set the ViewModel to each fragment
//            gender.setViewModel(userDetailModel)
//            sedentary.setViewModel(userDetailModel)


            btBack.setOnClickListener {
                if (userPager.currentItem > 0) {
                    userPager.currentItem -= 1
                    tvNumIndicator.text = (""+(userPager.currentItem+1)+" / 6")
                }
            }
            btContinue.setOnClickListener {

                if (userPager.currentItem < (userPager.adapter?.itemCount?.minus(1) ?: 0)) {
                    userPager.currentItem += 1
                    tvNumIndicator.text = (""+(userPager.currentItem+1)+" / 6")
                }
            }

        }

    }
}