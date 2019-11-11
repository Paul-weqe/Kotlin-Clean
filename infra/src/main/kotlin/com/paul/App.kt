package com.paul

import com.paul.controllers.posts
import com.paul.repos.PostRepository
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.CORS
import io.ktor.features.ContentNegotiation
import io.ktor.jackson.jackson
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

val postRepo = PostRepository()

fun main(){
    embeddedServer(Netty, port = 8081, module = Application::mainModule).start(wait = true)
}


fun Application.mainModule(){
    routing {
        posts()
    }

    install(ContentNegotiation){
        jackson{

        }
    }

    install(CORS){

    }

}
