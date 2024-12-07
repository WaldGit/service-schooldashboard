package com.example.demo.ports.out;

import com.example.demo.domain.SchoolClass;
import com.example.demo.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolClassRepository extends JpaRepository<SchoolClass, Integer> {
}
