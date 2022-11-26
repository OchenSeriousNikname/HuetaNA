package com.example.huetana

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Information : AppCompatActivity() {
    private val dbHelper = DBHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)

        val id = intent.getLongExtra("id", 0)

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
        val buttonDelete = findViewById<Button>(R.id.Delete)
        buttonDelete.setOnClickListener {
            dbHelper.remove(id)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }
    }
}