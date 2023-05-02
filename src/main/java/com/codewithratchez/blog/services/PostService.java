package com.codewithratchez.blog.services;

import com.codewithratchez.blog.entities.Post;
import com.codewithratchez.blog.payloads.PostDto;
import com.codewithratchez.blog.payloads.PostResponse;

import java.util.List;

public interface PostService {
    //create post
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    //update post
    PostDto updatePost(PostDto postDto, Integer postId);

    //delete post
    void deletePost(Integer postId);

    //get all posts

    PostResponse getAllPost(Integer pageNumber, Integer pageSize);

    //get single post
    PostDto getPostById(Integer postId);

    //get all posts by category
    List<PostDto> getPostsByCategory(Integer categoryId);

    //get all post by user
    List<PostDto> getPostsByUser(Integer userId);

    //search posts
    List<Post> searchPosts(String keyword);
}
