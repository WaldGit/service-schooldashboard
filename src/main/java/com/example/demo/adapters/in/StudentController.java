package com.example.demo.adapters.in;

import com.example.demo.domain.Student;
import com.example.demo.ports.in.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentUseCase) {
        this.studentService = studentUseCase;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        System.out.println("create student");
        return studentService.saveStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        System.out.println("all students");
        return studentService.getAllStudents();
    }
}
