package com.paul.post

import com.paul.DoesNotExistException
import com.paul.entity.Post
import com.paul.repos.IPostRepository
import java.util.logging.Logger

class EditPostUsingName (
    val postName: String,
    val post: Post,
    val postRepository: IPostRepository<Post, Int>
){

    val LOG = Logger.getLogger(EditPostUsingName::class.java.name)

    fun execute(){
        post.id = getPostDetails().id
        postRepository.merge(post)
    }

    fun getPostDetails(): Post{
        postRepository.findByName(postName)?.let { return post }
        throw DoesNotExistException("Post With Name {} Could not be found")
    }

}