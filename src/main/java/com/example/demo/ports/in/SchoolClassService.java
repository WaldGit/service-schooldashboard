package com.example.demo.ports.in;

import com.example.demo.domain.SchoolClass;
import com.example.demo.domain.Student;

import java.util.List;

public interface SchoolClassService {
    SchoolClass createClass(String name);

    List<SchoolClass> getAllClasses();

    Student addStudentToClass(int classId, String name);

    List<Student> getStudentsInClass(int classId);
}
