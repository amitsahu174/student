package com.example.jpa.example.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private long sid;
    private String name;
    private String surename;
    private String father_name;
    private int age;
    private String stream;
    private int year;
    private float fees;
}
