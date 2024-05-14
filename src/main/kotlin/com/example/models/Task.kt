package com.example.models

import kotlinx.serialization.Serializable

@Serializable
class Task(
    var title: String,
    var description: String
)