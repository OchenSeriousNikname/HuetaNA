package com.example.huetana

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Settings : AppCompatActivity() {
    private val dbHelper = DBHelper(this)
    private val list = mutableListOf<Todo>()
    private lateinit var adapter: RecyclerAdapter
    val editText1 = findViewById<EditText>(R.id.editTextTextPersonName4)
    val editText2 = findViewById<EditText>(R.id.editTextTextPersonName2)
    val editText3 = findViewById<EditText>(R.id.editTextTextPersonName3)
    val editText4 = findViewById<EditText>(R.id.editTextTextPersonName)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val buttonESC = findViewById<Button>(R.id.button6)
        buttonESC.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val buttonSave = findViewById<Button>(R.id.button)
        buttonSave.setOnClickListener {
            val title = editText1.text.toString()
            val id = dbHelper.add(title)
            list.add(Todo(id, title))
            adapter.notifyItemInserted(list.lastIndex)
        }
    }
}