package com.example.jpa.example.studentController;

import java.sql.SQLException;
import java.util.List;

import com.example.jpa.example.dto.StudentDto;
import com.example.jpa.example.helper.BaseResponseHelper;
import com.example.jpa.example.helper.CustomeExceptionHelper;
import com.example.jpa.example.repo.PersonalRepo;
import com.example.jpa.example.service.PersonalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class StudentController {

    @Autowired
    private PersonalService personalService;

    @GetMapping("/get")
    public String health() {
        return "Running";
    }

    @GetMapping("/list")
    public BaseResponseHelper<List<StudentDto>> getStudentList(@RequestParam(defaultValue = "NA") String name,
            @RequestParam(defaultValue = "NA") String surename,
            @RequestParam(defaultValue = "NA") String stream) throws SQLException {
        System.out.println("name->" + name);
        List<StudentDto> studentList = personalService.getStudentList(name, surename, stream);
        if (studentList.size() > 0) {
            return new BaseResponseHelper<List<StudentDto>>(HttpStatus.OK.value(), "Success", studentList);
        } else {
            throw new CustomeExceptionHelper("No Record Found");
        }

    }
}
