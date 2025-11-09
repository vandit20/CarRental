package com.example.carrental

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import java.text.SimpleDateFormat
import java.util.*

class BookingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)

        val btnBack = findViewById<ImageButton>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }

        val tvSelectedCar = findViewById<TextView>(R.id.tvSelectedCar)
        val tvBookingDate = findViewById<TextView>(R.id.tvBookingDate)
        val etDuration = findViewById<EditText>(R.id.etDuration)
        val etPickupLocation = findViewById<EditText>(R.id.etPickupLocation)

        // Receive car name from previous activity
        val carName = intent.getStringExtra("carName")
        tvSelectedCar.text = "Car: $carName"


        // Set up Date Picker
        tvBookingDate.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { _, selectedYear, selectedMonth, selectedDay ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(selectedYear, selectedMonth, selectedDay)
                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.US)
                tvBookingDate.text = dateFormat.format(selectedDate.time)
            }, year, month, day)

            dpd.show()
        }

        val btnConfirmBooking = findViewById<MaterialButton>(R.id.btnConfirmBooking)
        btnConfirmBooking.setOnClickListener {
            val carName = intent.getStringExtra("carName")
            val carPriceINR = intent.getIntExtra("carPriceINR", 0) // Fetch as Int
            val duration = etDuration.text.toString().toIntOrNull() ?: 1

            if (carName != null && carPriceINR > 0) {
                val intent = Intent(this, PaymentActivity::class.java)
                intent.putExtra("carName", carName)
                intent.putExtra("carPriceINR", carPriceINR) // Pass INR price
                intent.putExtra("duration", duration)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Car details are missing.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}