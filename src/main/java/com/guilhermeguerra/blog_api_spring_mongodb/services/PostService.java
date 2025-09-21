package com.guilhermeguerra.blog_api_spring_mongodb.services;

import com.guilhermeguerra.blog_api_spring_mongodb.domain.Post;
import com.guilhermeguerra.blog_api_spring_mongodb.repository.PostRepository;
import com.guilhermeguerra.blog_api_spring_mongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;


    public Post findById(String id) {
        Optional<Post> post = repository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado!"));
    }
}
