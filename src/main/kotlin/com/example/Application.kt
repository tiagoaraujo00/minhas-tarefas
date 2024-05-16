package com.example

import com.example.database.DatabaseSingleton
import com.example.plugins.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import kotlinx.serialization.json.Json

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    DatabaseSingleton.init()
    install(ContentNegotiation) {
        json(Json {
            ignoreUnknownKeys = true
        })
    }
    configureRouting()
}
