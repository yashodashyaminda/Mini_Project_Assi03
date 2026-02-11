package com.example.taskmanager

import kotlinx.coroutines.flow.Flow

class TaskRepository(private val taskDao: TaskDao) {
    // get all tasks
    val allTasks: Flow<List<Task>> = taskDao.getAllTasks()

    // insert new task
    suspend fun insert(task: Task) {
        taskDao.insert(task)
    }

    // update task
    suspend fun update(task: Task) {
        taskDao.update(task)
    }

    // delete task
    suspend fun delete(task: Task) {
        taskDao.delete(task)
    }
}
