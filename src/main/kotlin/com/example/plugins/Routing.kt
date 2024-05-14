package com.example.plugins

import com.example.models.Task
import com.example.repositories.TasksReposiory
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {

    val repository = TasksReposiory()
    routing {
        get("/tasks") {
            call.respond(repository.tasks)
        }
        post("/tasks") {
            val task = call.receive<Task>()
            repository.save(task)
            call.respondText("Task was created", status = HttpStatusCode.Created)
        }
    }
}
