package com.example.plugins

import com.example.dto.TaskRequest
import com.example.dto.toTaskResponse
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
            val response = repository.tasks().map { it.toTaskResponse() }
            call.respond(response)
        }
        post("/tasks") {
            val request = call.receive<TaskRequest>()
            repository.save(request.toTask())?.let {
                call.respondText(
                    "Task created",
                    status = HttpStatusCode.Created
                )
            } ?: call.respondText(
                "Task not created",
                status = HttpStatusCode.BadRequest
            )
        }
    }
}
