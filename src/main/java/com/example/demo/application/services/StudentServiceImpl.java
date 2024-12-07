package com.example.demo.application.services;

import com.example.demo.domain.Student;
import com.example.demo.ports.in.StudentService;
import com.example.demo.ports.out.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Student saveStudent(Student student) {

        return repository.save(student);
    }

    @Override
    public Student getStudent(String id) {
        return null;
    }

    @Override
    public Student updateStudent(String id, String name, LocalDate birthDay) {
        return null;
    }

    @Override
    public void deleteStudent(String id) {

    }

    @Override
    public List<Student> getAllStudents() {
        return repository.findAll();
    }
}

