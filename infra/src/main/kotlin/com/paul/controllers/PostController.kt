package com.paul.controllers

import io.ktor.application.call
import io.ktor.request.receive
import io.ktor.routing.Routing
import io.ktor.routing.post
import com.paul.entity.Post
import com.paul.post.CreatePost
import com.paul.postRepo
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.routing.get

fun Routing.posts(){

    post("/political-post"){

        try{
            val newPost = call.receive<Post>()
            val createPost = CreatePost(newPost, postRepo)
            call.respond(HttpStatusCode.Created, createPost.execute().toMap())
        } catch (e: Exception){
            call.respond(HttpStatusCode.NotAcceptable, mapOf("error" to e.message))
        }

    }

    get("/political-post"){
        val allPosts = postRepo.findAll()
        val allPostsMap = HashMap<String, Any>()
        allPosts.forEach {
            val post = it as Post
            allPostsMap[post.id.toString()] = post.toMap()
        }
        call.respond(HttpStatusCode.Accepted, allPostsMap)
    }

}