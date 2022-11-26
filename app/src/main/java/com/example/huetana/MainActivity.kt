package com.example.huetana

import android.app.Activity
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

    val REQUEST_CODE = 1

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            // получение данных от Activity2
            val result = data?.getStringExtra(SecondActivity.RESULT_KEY)
            // в result лежит строка "тут какой-то результат (строка)"
        }
    }
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
            intent.putExtra("id", list[it].id)
            startActivityForResult(intent, REQUEST_CODE)

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
            startActivityForResult(intent, REQUEST_CODE)
        }
    }
}
