package com.example.demo.adapters.out;

import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.domain.Student;
import com.example.demo.ports.out.StudentRepository;

@Repository
@Primary
public interface JpaStudentRepository extends StudentRepository {

}
