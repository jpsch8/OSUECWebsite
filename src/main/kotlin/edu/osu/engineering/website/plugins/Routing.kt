package edu.osu.engineering.website.plugins

import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.autohead.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.netty.handler.codec.http.HttpVersion

fun Application.configureRouting() {
    install(StatusPages) {
        status(HttpStatusCode.NotFound) { code ->
            call.respondText("404 not found sorry")
        }
        exception<Throwable> { call, cause ->
            call.respondText(text = "500: $cause" , status = HttpStatusCode.InternalServerError)
        }
    }
    install(AutoHeadResponse)
    routing {
        staticResources("/", "static") {
            default("notfound.html")
            enableAutoHeadResponse()
        }
        get("/hello"){
            call.respondText("Hello back")
        }
    }
}
