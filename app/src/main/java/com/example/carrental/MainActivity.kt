package com.example.carrental

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Function to set up click listener for a car button
        fun setupCarClickListener(buttonId: Int, carName: String, carPrice: Int, carMileage: String, carSeating: String, carFuel: String, carTransmission: String, carImageResId: Int) {
            findViewById<Button>(buttonId).setOnClickListener {
                val intent = Intent(this, CarDetailsActivity::class.java)
                intent.putExtra("carName", carName)
                intent.putExtra("carPrice", carPrice) // Pass a clean Int here
                intent.putExtra("carMileage", carMileage)
                intent.putExtra("carSeating", carSeating)
                intent.putExtra("carFuel", carFuel)
                intent.putExtra("carTransmission", carTransmission)
                intent.putExtra("carImage", carImageResId)
                startActivity(intent)
            }
        }

        // Car 1 Details: Toyota Innova
        setupCarClickListener(
            R.id.btnViewCar1,
            "Toyota Innova",
            1200, // Pass a clean Int
            "15 km/l",
            "7 seats",
            "Diesel",
            "Manual",
            R.mipmap.ic_innova_foreground
        )

        // Car 2 Details: Honda City
        setupCarClickListener(
            R.id.btnViewCar2,
            "Honda City",
            8900, // Pass a clean Int
            "18 km/l",
            "5 seats",
            "Petrol",
            "Automatic",
            R.mipmap.ic_honda_foreground
        )

        // Car 3 Details: Maruti Swift
        setupCarClickListener(
            R.id.btnViewCar3,
            "Maruti Swift",
            7120, // Pass a clean Int
            "22 km/l",
            "5 seats",
            "Petrol",
            "Manual",
            R.mipmap.ic_swift_foreground
        )

        // Car 4 Details: Mahindra Thar
        setupCarClickListener(
            R.id.btnViewCar4,
            "Mahindra Thar",
            13350, // Pass a clean Int
            "12 km/l",
            "4 seats",
            "Diesel",
            "Manual",
            R.mipmap.ic_thar_foreground
        )

        // Car 5 Details: Hyundai Creta
        setupCarClickListener(
            R.id.btnViewCar5,
            "Hyundai Creta",
            11570, // Pass a clean Int
            "17 km/l",
            "5 seats",
            "Petrol",
            "Automatic",
            R.mipmap.ic_creta_foreground
        )

        // Car 6 Details: Tata Nexon
        setupCarClickListener(
            R.id.btnViewCar6,
            "Tata Nexon",
            9790, // Pass a clean Int
            "20 km/l",
            "5 seats",
            "Petrol",
            "Manual",
            R.mipmap.ic_nexon_foreground
        )

        // Car 7 Details: Kia Seltos
        setupCarClickListener(
            R.id.btnViewCar7,
            "Kia Seltos",
            12015, // Pass a clean Int
            "16 km/l",
            "5 seats",
            "Petrol",
            "Automatic",
            R.mipmap.ic_seltos_foreground
        )

        // Car 8 Details: Maruti Baleno
        setupCarClickListener(
            R.id.btnViewCar8,
            "Maruti Baleno",
            8010, // Pass a clean Int
            "23 km/l",
            "5 seats",
            "Petrol",
            "Manual",
            R.mipmap.ic_baleno_foreground
        )

        // Car 9 Details: Renault Kwid
        setupCarClickListener(
            R.id.btnViewCar9,
            "Renault Kwid",
            6230, // Pass a clean Int
            "22 km/l",
            "5 seats",
            "Petrol",
            "Manual",
            R.mipmap.ic_kwid_foreground
        )

        // Car 10 Details: Toyota Fortuner
        setupCarClickListener(
            R.id.btnViewCar10,
            "Toyota Fortuner",
            16020, // Pass a clean Int
            "10 km/l",
            "7 seats",
            "Diesel",
            "Automatic",
            R.mipmap.ic_fortuner_foreground
        )
    }
}