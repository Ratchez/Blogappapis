package com.codewithratchez.blog.services.impl;

import com.codewithratchez.blog.entities.Category;
import com.codewithratchez.blog.entities.Post;
import com.codewithratchez.blog.entities.User;
import com.codewithratchez.blog.exceptions.ResourceNotFoundException;
import com.codewithratchez.blog.payloads.PostDto;
import com.codewithratchez.blog.repositories.CategoryRepo;
import com.codewithratchez.blog.repositories.PostRepo;
import com.codewithratchez.blog.repositories.UserRepo;
import com.codewithratchez.blog.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId){
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User"));
        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category"));

        Post post = this.modelMapper.map(postDto, Post.class);
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);

        Post newPost = postRepo.save(post);

        return this.modelMapper.map(newPost, PostDto.class);
    }
    @Override
    public PostDto updatePost(PostDto postDto, Integer postId){
        Post post = postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post"));
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setImageName(postDto.getImageName());

        Post updatedPost = postRepo.save(post);
        return this.modelMapper.map(updatedPost, PostDto.class);
    }
    @Override
    public void deletePost(Integer postId){
        Post post = postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post"));
        postRepo.delete(post);
    }
    @Override
    public List<PostDto> getAllPost(Integer pageNumber, Integer pageSize){
        Pageable p = PageRequest.of(pageNumber, pageSize);
        Page<Post> pagePost = postRepo.findAll(p);
        List<Post> allPosts = pagePost.getContent();
        List<PostDto> postDtos = allPosts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public PostDto getPostById(Integer postId) {
        Post post = postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post"));
        return this.modelMapper.map(post, PostDto.class);
    }

    @Override
    public List<PostDto> getPostsByCategory(Integer categoryId) {
        Category cat = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category"));
        List<Post> posts = postRepo.findByCategory(cat);

        List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public List<PostDto> getPostsByUser(Integer userId) {
        User user1 = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User"));
        List<Post> posts = postRepo.findByUser(user1);

        List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public List<Post> searchPosts(String keyword) {
        return null;
    }
}
