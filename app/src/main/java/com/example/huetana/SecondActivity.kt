package com.example.huetana

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    companion object {
        const val RESULT_KEY = "result"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)
        val button = findViewById<Button>(R.id.Delete)
        button.setOnClickListener {
            val returnIntent = Intent()
            returnIntent.putExtra(RESULT_KEY, "delete najali")
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }
    }
}