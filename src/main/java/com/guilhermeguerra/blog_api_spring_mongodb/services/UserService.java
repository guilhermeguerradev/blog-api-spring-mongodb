package com.guilhermeguerra.blog_api_spring_mongodb.services;

import com.guilhermeguerra.blog_api_spring_mongodb.domain.User;
import com.guilhermeguerra.blog_api_spring_mongodb.repository.UserRepository;
import com.guilhermeguerra.blog_api_spring_mongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado!"));
    }
}
