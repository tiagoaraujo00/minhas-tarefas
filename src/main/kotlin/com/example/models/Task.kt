package com.example.models

import org.jetbrains.exposed.sql.Table
import java.util.*


class Task(
    val id: UUID = UUID.randomUUID(),
    var title: String,
    var description: String,
    val isDone: Boolean = false,
)

object Tasks : Table() {
    val id = uuid("id").autoGenerate()
    val title = text("title")
    val description = text("description")
    val isDone = bool("isDone")

    override val primaryKey = PrimaryKey(id)
}
