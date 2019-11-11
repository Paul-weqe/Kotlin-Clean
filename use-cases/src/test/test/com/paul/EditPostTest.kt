package com.paul

import com.paul.entity.Post
import com.paul.post.CreatePost
import org.junit.Before
import org.junit.Test


class EditPostTest {

    val postRepository = TPostRepositoryT()

    @Before
    fun setUp(){

    }

    fun createPost(postName: String): Post {
        val post = Post(name = postName)
        val create = CreatePost(post, postRepository)
        return create.execute()
    }
}