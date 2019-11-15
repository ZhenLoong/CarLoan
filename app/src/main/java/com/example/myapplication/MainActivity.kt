package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.apply {
            button.setOnClickListener() {
                val priceInput: Double = carPriceInput.text.toString().toDouble()
                val loanInput: Int = loanInput.text.toString().toInt()
                val downPayInput: Double = downPayInput.text.toString().toDouble()
                val interestInput: Int = interestInput.text.toString().toInt()

                val carLoan: Double = priceInput - downPayInput
                val interest: Double = carLoan * (interestInput / 100.0) * loanInput
                val repayAmt: Double = (carLoan + interest) / loanInput / 12.000000

                carLoanPrice.text = "%.2f".format(carLoan)
                interestPrice.text = "%.2f".format(interest)
                repayPrice.text="%.2f".format(repayAmt)


            }
        }
    }
}
