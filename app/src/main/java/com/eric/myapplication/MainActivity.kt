package com.eric.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter : TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) { 
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todoAdapter = TodoAdapter(mutableListOf())

        rvTodoItems.adapter = todoAdapter
        rvTodoItems.layoutManager = LinearLayoutManager(this)

        btnAddToDo.setOnClickListener {
            val todoTitle = etToDoTitle.text.toString()

            if (todoTitle.isNotEmpty()) {
                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                etToDoTitle.text.clear()
            }
        }

        btnDeleteToDo.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }
    }
}
