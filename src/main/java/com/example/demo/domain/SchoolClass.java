package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class SchoolClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;


    @OneToMany(mappedBy = "schoolClass", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Student> students = new ArrayList<>();

    // Constructors
    public SchoolClass() {}

    public SchoolClass(String name) {
    this.name = name;
    }

    public void addStudent(Student student) {
        students.add(student);
        student.setSchoolClass(this);
    }

    public void removeStudent(Student student) {
        students.remove(student);
        student.setSchoolClass(null);
    }
}
