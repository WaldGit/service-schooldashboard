package com.example.demo.application;

import com.example.demo.domain.SchoolClass;
import com.example.demo.domain.Student;
import com.example.demo.ports.in.SchoolClassService;
import com.example.demo.ports.in.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDate;

@SpringBootApplication(scanBasePackages = "com.example")
@EntityScan(basePackages = "com.example")
@EnableJpaRepositories(basePackages = "com.example")

public class DemoApplication {

	private final StudentService studentService;
	private final SchoolClassService schoolClassService;

	// Constructor injection of the StudentService
	public DemoApplication(StudentService studentService, SchoolClassService schoolClassService) {
		this.studentService = studentService;
        this.schoolClassService = schoolClassService;
    }

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() {
		return args -> {
			// Adding students to the database (using saveStudent)


			SchoolClass schoolClass = schoolClassService.createClass("Class A");

			schoolClassService.addStudentToClass(schoolClass.getId(), "Alice",  LocalDate.of(2024,1,1));


			// Optionally, print out all students
			System.out.println("All students: " + studentService.getAllStudents());
		};
	}

}
