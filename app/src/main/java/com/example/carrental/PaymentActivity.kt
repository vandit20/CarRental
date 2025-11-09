package com.example.carrental

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import java.text.NumberFormat
import java.util.*

class PaymentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        val btnBack = findViewById<ImageButton>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }

        val tvPaymentCarName = findViewById<TextView>(R.id.tvPaymentCarName)
        val tvRentalAmount = findViewById<TextView>(R.id.tvRentalAmount)
        val tvGstAmount = findViewById<TextView>(R.id.tvGstAmount)
        val tvTotalAmount = findViewById<TextView>(R.id.tvTotalAmount)

        val etCardNumber = findViewById<EditText>(R.id.etCardNumber)
        val etExpiryDate = findViewById<EditText>(R.id.etExpiryDate)
        val etCVV = findViewById<EditText>(R.id.etCVV)
        val btnPayNow = findViewById<MaterialButton>(R.id.btnPayNow)

        // Get car name, price, and duration from the Intent
        val carName = intent.getStringExtra("carName")
        val carPriceINR = intent.getIntExtra("carPriceINR", 0)
        val duration = intent.getIntExtra("duration", 1)
        tvPaymentCarName.text = "Car: $carName"

        // Calculate all amounts
        val basePrice = carPriceINR * duration
        val gstRate = 0.18 // 18% GST
        val gstAmount = basePrice * gstRate
        val totalAmountWithGST = basePrice + gstAmount

        // Format amounts and display them
        val currencyFormatter = NumberFormat.getCurrencyInstance(Locale("en", "in"))
        tvRentalAmount.text = currencyFormatter.format(basePrice)
        tvGstAmount.text = currencyFormatter.format(gstAmount)
        tvTotalAmount.text = currencyFormatter.format(totalAmountWithGST)

        // On Pay Now
        btnPayNow.setOnClickListener {
            val cardNumber = etCardNumber.text.toString()
            val expiry = etExpiryDate.text.toString()
            val cvv = etCVV.text.toString()

            if (cardNumber.isNotEmpty() && expiry.isNotEmpty() && cvv.isNotEmpty()) {
                Toast.makeText(this, "Payment Successful for $carName!", Toast.LENGTH_LONG).show()
                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please enter all details", Toast.LENGTH_SHORT).show()
            }
        }
    }
}