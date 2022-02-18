package com.example.jpa.example.service;

import java.sql.SQLException;
import java.util.List;

import com.example.jpa.example.dto.StudentDto;

public interface PersonalService {

    public List<StudentDto> getStudentList(String name, String surename, String stream) throws SQLException;
}
