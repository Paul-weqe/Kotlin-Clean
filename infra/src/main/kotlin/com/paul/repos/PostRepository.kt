package com.paul.repos

import com.paul.entity.Post

class PostRepository: BaseRepository<Post, Int>(), IPostRepository<Post, Int>