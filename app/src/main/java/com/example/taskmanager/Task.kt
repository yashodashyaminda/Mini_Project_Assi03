package com.example.taskmanager

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
// Db TAble Create
@Entity(tableName = "task_table")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String
) : Serializable
