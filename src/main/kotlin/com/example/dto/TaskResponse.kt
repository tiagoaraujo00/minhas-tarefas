package com.example.dto

import com.example.models.Task
import kotlinx.serialization.Serializable

@Serializable
class TaskResponse(
    val id: String,
    val title: String,
    val description: String,
    val isDone: Boolean
)

fun Task.toTaskResponse() = TaskResponse(
    id = id.toString(),
    title = title,
    description = description,
    isDone = isDone
)