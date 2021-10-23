package com.eric.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    /**
     * What is an Activity?
     * Answer: An activity is just a single screen in our App
     *
     * What is a View?
     * Answer: A visible element inside of an Activity or on our Screen (Button, Text Label, etc)
     *
     * What is an Adapter?
     * Answer: A class in which we define the layout we want to use for those items, and logic
     */

    // lateinit = A promise to kotlin that we will initialize this later

    private lateinit var todoAdapter : TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) { // Called once this Activity is created
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