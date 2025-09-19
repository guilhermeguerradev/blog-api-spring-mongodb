package com.guilhermeguerra.blog_api_spring_mongodb.dto;

import com.guilhermeguerra.blog_api_spring_mongodb.domain.User;
import org.springframework.beans.BeanUtils;

public class UserDto {
    private String id;
    private String name;
    private String email;

    public UserDto() {}

    public UserDto(User user) {
        // Copia automaticamente os dados da entidade 'user' para o objeto atual (this)
        // Isso evita escrever manualmente: this.name = user.getName(); etc.
        BeanUtils.copyProperties(user, this);

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
