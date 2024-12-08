package com.example.demo.adapters.in;


import com.example.demo.domain.SchoolClass;
import com.example.demo.domain.Student;
import com.example.demo.ports.in.SchoolClassService;
import com.example.demo.ports.in.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school-class")
public class SchoolClassController {
    private final SchoolClassService schoolClassService;

    public SchoolClassController(SchoolClassService schoolClassService) {
        this.schoolClassService = schoolClassService;
    }

    // Create a new class
    @PostMapping
    public ResponseEntity<SchoolClass> createClass(@RequestBody SchoolClassRequest request) {
        SchoolClass schoolClass = schoolClassService.createClass(request.getName());
        return ResponseEntity.ok(schoolClass);
    }

    // Get all classes
    @GetMapping
    public ResponseEntity<List<SchoolClass>> getAllClasses() {
        return ResponseEntity.ok(schoolClassService.getAllClasses());
    }

    // Add a student to a class
    @PostMapping("/{classId}/students")
    public ResponseEntity<Student> addStudentToClass(
            @PathVariable int classId,
            @RequestBody StudentRequest request) {
        Student student = schoolClassService.addStudentToClass(classId, request.getName(), request.getBirthday());
        return ResponseEntity.ok(student);
    }

    // Get students in a class
    @GetMapping("/{classId}/students")
    public ResponseEntity<List<Student>> getStudentsInClass(@PathVariable int classId) {
        return ResponseEntity.ok(schoolClassService.getStudentsInClass(classId));
    }

}
