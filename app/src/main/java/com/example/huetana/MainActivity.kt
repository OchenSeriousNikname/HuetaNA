package com.example.huetana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.huetana.R
import android.content.ContentValues
import android.content.Intent
import android.database.Cursor

class MainActivity : AppCompatActivity() {
    private val list = mutableListOf<Todo>()
    private lateinit var adapter: RecyclerAdapter
    val dbHelper = DBHelper(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editText = findViewById<EditText>(R.id.editText)

        list.addAll(dbHelper.getAll())

        adapter = RecyclerAdapter(list) {

         /*   dbHelper.remove( list[it].id)
            list.removeAt(it)
            adapter.notifyItemRemoved(it) */

                val intent = Intent(this, Information::class.java)
                startActivity(intent)

        }

        val recyclerView = findViewById<RecyclerView>(R.id.spisok)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val buttonAdd = findViewById<Button>(R.id.button)
        buttonAdd.setOnClickListener {
            /* val title = editText.text.toString()
            val id = dbHelper.add(title)
            list.add(Todo(id, title))
            adapter.notifyItemInserted(list.lastIndex) */
            val intent = Intent(this, Settings::class.java)
            startActivity(intent)
        }
    }
}
