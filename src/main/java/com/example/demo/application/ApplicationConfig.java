package com.example.demo.application;

import com.example.demo.adapters.out.JpaStudentRepository;
import com.example.demo.application.services.StudentServiceImpl;
import com.example.demo.ports.in.StudentService;
import com.example.demo.ports.out.StudentRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
//    @Bean
//    public StudentService studentService(StudentRepository repository) {
//        System.out.println("loading services");
//        return new StudentServiceImpl(repository);
//    }

    /*@Bean
    public StudentRepository studentRepository() {
        return new JpaStudentRepository();
    }*/
}

