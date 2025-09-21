package com.guilhermeguerra.blog_api_spring_mongodb.config;

import com.guilhermeguerra.blog_api_spring_mongodb.domain.Post;
import com.guilhermeguerra.blog_api_spring_mongodb.domain.User;
import com.guilhermeguerra.blog_api_spring_mongodb.dto.AuthorDto;
import com.guilhermeguerra.blog_api_spring_mongodb.repository.PostRepository;
import com.guilhermeguerra.blog_api_spring_mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cglib.core.Local;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    DateTimeFormatter dtm = DateTimeFormatter.ofPattern("dd/MM/yyyy").withZone(java.time.ZoneId.of("GMT"));


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        postRepository.deleteAll();
        userRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        Post post1 = new Post(null, LocalDate.parse("21/03/2018",dtm), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDto(maria));
        Post post2 = new Post(null, LocalDate.parse("23/03/2018",dtm), "Bom dia", "Acordei feliz hoje!", new AuthorDto(maria));

        userRepository.saveAll(Arrays.asList(maria,alex,bob));
        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
