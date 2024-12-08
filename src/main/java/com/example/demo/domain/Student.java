package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private LocalDate birthday;

    public Student() {
    }

    public Student(String studentName, LocalDate birthDay) {
        this.name = studentName;
        this.birthday = birthDay;
    }


    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', birthDate=" + birthday + '}';
    }

    @ManyToOne
    @JoinColumn(name = "class_id")
    private SchoolClass schoolClass;


}
