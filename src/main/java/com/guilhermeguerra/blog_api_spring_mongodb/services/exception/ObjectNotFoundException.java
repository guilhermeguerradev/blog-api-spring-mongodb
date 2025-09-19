package com.guilhermeguerra.blog_api_spring_mongodb.services.exception;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(String message) {
        super(message);
    }
}
