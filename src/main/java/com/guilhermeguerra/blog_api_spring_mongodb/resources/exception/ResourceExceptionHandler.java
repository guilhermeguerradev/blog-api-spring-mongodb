package com.guilhermeguerra.blog_api_spring_mongodb.resources.exception;

import com.guilhermeguerra.blog_api_spring_mongodb.services.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// Anotação que permite centralizar o tratamento de exceções lançadas pelos controladores da aplicação
@ControllerAdvice
public class ResourceExceptionHandler {

    // Este método trata exceções do tipo ObjectNotFoundException lançadas nos controladores.
    // Quando essa exceção ocorre, retorna uma resposta HTTP 404 (NOT FOUND) com um corpo detalhando o erro.

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandarError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandarError err = new StandarError(System.currentTimeMillis(),status.value(),"Não encontrado", e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
    // Handler para ObjectNotFoundException:
    // retorna resposta 404 com detalhes do erro em formato padronizado.



}
