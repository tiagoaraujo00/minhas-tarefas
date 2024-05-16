package com.example.repositories

import com.example.database.dao.TaskDao
import com.example.models.Task

class TasksReposiory(
    private val dao: TaskDao = TaskDao()
) {

    suspend fun tasks() = dao.findAll()

    suspend fun save(task: Task) = dao.save(task)
}