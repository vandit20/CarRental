package com.example.carrental

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import java.text.NumberFormat
import java.util.*

class CarDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_details)

        val btnBack = findViewById<ImageButton>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }

        val tvCarName = findViewById<TextView>(R.id.tvCarName)
        val tvCarPrice = findViewById<TextView>(R.id.tvCarPrice)
        val tvCarDescription = findViewById<TextView>(R.id.tvCarDescription)
        val ivCarImage = findViewById<ImageView>(R.id.ivCarImage)
        val btnBookNow = findViewById<MaterialButton>(R.id.btnBookNow)

        // Receive data from MainActivity
        val carName = intent.getStringExtra("carName")
        val carPrice = intent.getIntExtra("carPrice", 0) // Correctly fetch the price as an Int
        val carMileage = intent.getStringExtra("carMileage")
        val carSeating = intent.getStringExtra("carSeating")
        val carFuel = intent.getStringExtra("carFuel")
        val carTransmission = intent.getStringExtra("carTransmission")
        val carImage = intent.getIntExtra("carImage", R.mipmap.ic_launcher)

        // Set data to UI
        tvCarName.text = carName
        ivCarImage.setImageResource(carImage)

        // Combine all details into a dynamic description string
        val description = "Mileage: $carMileage\n" +
                "Seating: $carSeating\n" +
                "Fuel Type: $carFuel\n" +
                "Transmission: $carTransmission"

        tvCarDescription.text = description

        // Format the price directly in INR
        // Since carPrice is already an Int, no need for toIntOrNull()
        val formattedINRPrice = NumberFormat.getCurrencyInstance(Locale("en", "in")).format(carPrice)
        tvCarPrice.text = "Price: $formattedINRPrice /day"

        // On Book Now → go to BookingActivity
        btnBookNow.setOnClickListener {
            val intent = Intent(this, BookingActivity::class.java)
            intent.putExtra("carName", carName)
            // Pass the Int price to the next activity
            intent.putExtra("carPriceINR", carPrice)
            startActivity(intent)
        }
    }
}