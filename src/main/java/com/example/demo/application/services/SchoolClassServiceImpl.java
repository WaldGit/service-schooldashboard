package com.example.demo.application.services;

import com.example.demo.domain.SchoolClass;
import com.example.demo.domain.Student;
import com.example.demo.ports.in.SchoolClassService;
import com.example.demo.ports.out.SchoolClassRepository;
import com.example.demo.ports.out.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SchoolClassServiceImpl implements SchoolClassService {


    private final SchoolClassRepository schoolClassRepository;
    private final StudentRepository studentRepository;

    public SchoolClassServiceImpl(SchoolClassRepository schoolClassRepository, StudentRepository studentRepository) {
        this.schoolClassRepository = schoolClassRepository;
        this.studentRepository = studentRepository;
    }

    @Transactional
    public SchoolClass createClass(String name) {
        return schoolClassRepository.save(new SchoolClass(name));
    }

    @Override
    public List<SchoolClass> getAllClasses() {
        return schoolClassRepository.findAll();
    }

    @Transactional
    public Student addStudentToClass(int classId, String studentName, LocalDate birthDay) {
        SchoolClass schoolClass = schoolClassRepository.findById(classId)
                .orElseThrow(() -> new RuntimeException("Class not found"));
        Student student = new Student(studentName,birthDay);
        schoolClass.addStudent(student);
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getStudentsInClass(int classId) {
        SchoolClass schoolClass = schoolClassRepository.findById(classId)
                .orElseThrow(() -> new RuntimeException("Class not found"));

        System.out.println("SchoolClass: " + schoolClass);
        System.out.println(schoolClass.getStudents());

        return schoolClass.getStudents();
    }
}
