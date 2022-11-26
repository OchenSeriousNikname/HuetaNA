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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        val editText1 = findViewById<EditText>(R.id.name)
        val editText2 = findViewById<EditText>(R.id.surname)
        val editText3 = findViewById<EditText>(R.id.dr)
        val editText4 = findViewById<EditText>(R.id.number)

        val buttonESC = findViewById<Button>(R.id.buttonCancel)
        buttonESC.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val buttonSave = findViewById<Button>(R.id.buttonSave)
        buttonSave.setOnClickListener {
            val title = editText1.text.toString()
            val id = dbHelper.add(title)
            list.add(Todo(id, title))
            adapter.notifyItemInserted(list.lastIndex)
            val intent = Intent(this, Information::class.java)
            startActivity(intent)
        }
    }
}