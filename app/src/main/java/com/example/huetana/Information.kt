package com.example.huetana

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Information : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)

        val buttonESC = findViewById<Button>(R.id.button3)
        buttonESC.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val buttonRED = findViewById<Button>(R.id.button4)
        buttonRED.setOnClickListener {

            val intent = Intent(this, Settings::class.java)
            startActivity(intent)
        }
    }
}