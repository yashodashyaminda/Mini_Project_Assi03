package com.example.taskmanager

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.taskmanager.databinding.ActivityAddEditBinding

class AddEditActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddEditBinding
    
    companion object {
        const val EXTRA_ID = "com.example.taskmanager.EXTRA_ID"
        const val EXTRA_TITLE = "com.example.taskmanager.EXTRA_TITLE"
        const val EXTRA_DESCRIPTION = "com.example.taskmanager.EXTRA_DESCRIPTION"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setHomeAsUpIndicator(android.R.drawable.ic_menu_close_clear_cancel)

        if (intent.hasExtra(EXTRA_ID)) {
            title = getString(R.string.title_edit_task)
            binding.editTextTitle.setText(intent.getStringExtra(EXTRA_TITLE))
            binding.editTextDescription.setText(intent.getStringExtra(EXTRA_DESCRIPTION))
        } else {
            title = getString(R.string.title_add_task)
        }
        // Save button click
        binding.buttonSave.setOnClickListener {
            saveTask()
        }
    }

    private fun saveTask() {
        val title = binding.editTextTitle.text.toString().trim()
        val description = binding.editTextDescription.text.toString().trim()

        if (title.isEmpty()) {
            Toast.makeText(this, getString(R.string.empty_validation_msg), Toast.LENGTH_SHORT).show()
            return
        }

        val data = Intent().apply {
            putExtra(EXTRA_TITLE, title)
            putExtra(EXTRA_DESCRIPTION, description)
            
            val id = intent.getIntExtra(EXTRA_ID, -1)
            if (id != -1) {
                putExtra(EXTRA_ID, id)
            }
        }

        setResult(Activity.RESULT_OK, data)
        finish()
    }
}
