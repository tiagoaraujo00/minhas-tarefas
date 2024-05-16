package com.example.database

import com.example.models.Tasks
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseSingleton {
    fun init(
        driverClassName: String = "org.h2.Driver",
        jdbcURL: String = "jdbc:h2:file:./build/db"
    ) {
        val database = Database.connect(jdbcURL, driverClassName)
        transaction(database) {
            SchemaUtils.create(Tasks)
        }
    }
}