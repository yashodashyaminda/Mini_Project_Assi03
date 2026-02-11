package com.example.taskmanager

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
// Get All Task
    @Query("SELECT * FROM task_table ORDER BY id DESC")
    fun getAllTasks(): Flow<List<Task>>
// insert new task
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(task: Task)
// update task
    @Update
    suspend fun update(task: Task)
// delete task
    @Delete
    suspend fun delete(task: Task)
}
