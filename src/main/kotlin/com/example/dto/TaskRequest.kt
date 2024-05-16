package com.example.dto

import com.example.models.Task
import kotlinx.serialization.Serializable

@Serializable
class TaskRequest(
    val title: String,
    val description: String
) {
    fun toTask() = Task(
        title = title,
        description = description
    )
}