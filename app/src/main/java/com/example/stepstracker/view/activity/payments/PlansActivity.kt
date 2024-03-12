package com.example.stepstracker.view.activity.payments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.stepstracker.R
import com.example.stepstracker.databinding.ActivityPlansBinding
import com.example.stepstracker.util.statusBarColorGrey

class PlansActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPlansBinding
    private var price : Float = 4.99F
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlansBinding.inflate(layoutInflater)
        setContentView(binding.root)
        statusBarColorGrey()

        binding.apply {

            tvMonthly.setOnClickListener {

                ivPlans.setImageResource(R.drawable.ic_plan_monthly)
                tvMonthly.setBackgroundResource(R.drawable.bn_purple_item)
                tvMonthly.setTextColor(getColor(R.color.white))
                tvYearly.setBackgroundResource(R.drawable.bn_item)
                tvYearly.setTextColor(getColor(R.color.default_text_color))

                btContinuePayment.text = getString(R.string.continue_4_99)

                price = 4.99F
            }

            tvYearly.setOnClickListener {

                ivPlans.setImageResource(R.drawable.ic_plan_yearly)
                tvMonthly.setBackgroundResource(R.drawable.bn_item)
                tvMonthly.setTextColor(getColor(R.color.default_text_color))
                tvYearly.setBackgroundResource(R.drawable.bn_purple_item)
                tvYearly.setTextColor(getColor(R.color.white))
                btContinuePayment.text = getString(R.string.continue_49_99)

                price = 49.99F
            }

            btContinuePayment.setOnClickListener {



            }

        }

    }
}