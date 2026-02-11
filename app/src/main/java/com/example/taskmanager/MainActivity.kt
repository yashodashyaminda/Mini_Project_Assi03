package com.example.taskmanager

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskmanager.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val taskViewModel: TaskViewModel by viewModels()

    private val addTaskLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            val title = data?.getStringExtra(AddEditActivity.EXTRA_TITLE)
            val description = data?.getStringExtra(AddEditActivity.EXTRA_DESCRIPTION)

            if (title != null && description != null) {
                val task = Task(title = title, description = description)
                taskViewModel.insert(task)
                Toast.makeText(this, "Task saved", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private val editTaskLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            val title = data?.getStringExtra(AddEditActivity.EXTRA_TITLE)
            val description = data?.getStringExtra(AddEditActivity.EXTRA_DESCRIPTION)
            val id = data?.getIntExtra(AddEditActivity.EXTRA_ID, -1)
            //edit task
            if (id != null && id != -1 && title != null && description != null) {
                val task = Task(id = id, title = title, description = description)
                taskViewModel.update(task)
                Toast.makeText(this, "Task updated", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Task not saved", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = TaskAdapter(
            onItemClicked = { task ->
                val intent = Intent(this@MainActivity, AddEditActivity::class.java).apply {
                    putExtra(AddEditActivity.EXTRA_ID, task.id)
                    putExtra(AddEditActivity.EXTRA_TITLE, task.title)
                    putExtra(AddEditActivity.EXTRA_DESCRIPTION, task.description)
                }
                editTaskLauncher.launch(intent)
            },
            onDeleteClicked = { task ->
                taskViewModel.delete(task)
                Toast.makeText(this, getString(R.string.delete_msg), Toast.LENGTH_SHORT).show()
            }
        )

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.setHasFixedSize(true)

        //Observe tasks from db
        taskViewModel.allTasks.observe(this) { tasks ->
            // Update the cached copy of the tasks in the adapter.
            tasks?.let { 
                adapter.submitList(it)
                binding.emptyViewText.visibility = if (it.isEmpty()) View.VISIBLE else View.GONE
            }
        }
        // add task button
        binding.buttonAddNote.setOnClickListener {
            val intent = Intent(this@MainActivity, AddEditActivity::class.java)
            addTaskLauncher.launch(intent)
        }
    }
}
