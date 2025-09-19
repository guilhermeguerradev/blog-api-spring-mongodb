package com.guilhermeguerra.blog_api_spring_mongodb.resources;

import com.guilhermeguerra.blog_api_spring_mongodb.domain.User;
import com.guilhermeguerra.blog_api_spring_mongodb.dto.UserDto;
import com.guilhermeguerra.blog_api_spring_mongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {
        List<User> list = service.findAll();
        List<UserDto> listDto = list.stream().map(x -> new UserDto(x)).toList();
        return ResponseEntity.ok().body(listDto);
    }
}
