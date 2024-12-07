package com.example.demo.ports.in;

import com.example.demo.domain.Student;

import java.time.LocalDate;
import java.util.List;

public interface StudentService {

    public Student saveStudent(Student student);

    public Student getStudent(String id);

    public Student updateStudent(String id, String name, LocalDate birthDay);

    public void deleteStudent(String id);

    public List<Student> getAllStudents();







}
