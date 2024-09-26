package edu.osu.engineering.website

import edu.osu.engineering.website.plugins.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

val server by lazy { embeddedServer(
    factory = Netty,
    port = 8080,
    host = "localhost",
    module = Application::module
) }

fun main() {
    server.start(wait = true)
}

fun Application.module() {
    configureFrameworks()
    configureSerialization()
    configureDatabases()
    configureMonitoring()
    configureHTTP()
    configureSecurity()
    configureRouting()
}
