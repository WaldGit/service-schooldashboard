package com.example.demo.adapters.in;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class StudentRequest {
    private String name;
    private LocalDate birthday;

}
