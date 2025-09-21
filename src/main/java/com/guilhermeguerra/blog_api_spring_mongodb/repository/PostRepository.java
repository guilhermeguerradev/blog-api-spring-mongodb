package com.guilhermeguerra.blog_api_spring_mongodb.repository;

import com.guilhermeguerra.blog_api_spring_mongodb.domain.Post;
import com.guilhermeguerra.blog_api_spring_mongodb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
