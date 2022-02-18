package com.example.jpa.example.serviceimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.example.jpa.example.dto.StudentDto;
import com.example.jpa.example.service.PersonalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalServiceImpl implements PersonalService {

    @Autowired
    private DataSource dataSource;

    @Override
    public List<StudentDto> getStudentList(String name, String surename, String stream) throws SQLException {
        // TODO Auto-generated method stub
        String q = "SELECT * FROM personal_details p left JOIN course_details c on p.sid=c.cid where 1";

        // Class.forName("com.mysql.jdbc.Driver");
        // Connection con = DriverManager.getConnection(url, uname, pass);
        if (!name.equalsIgnoreCase("NA")) {
            String temp = "\"" + name + "\"";

            q = q + " and p.name IN(" + temp + ")";

        }
        if (!surename.equalsIgnoreCase("NA")) {
            String temp = "\"" + surename + "\"";

            q = q + " and p.surename IN(" + temp + ")";

        }
        if (!stream.equalsIgnoreCase("NA")) {
            String temp = "\"" + stream + "\"";

            q = q + " and c.stream IN(" + temp + ")";

        }

        System.out.println("query->" + q);
        Connection con = dataSource.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(q);
        List<StudentDto> studentDtos = new ArrayList<StudentDto>();
        while (rs.next()) {

            StudentDto studentDto = new StudentDto();
            studentDto.setName(rs.getString("name"));
            studentDto.setFather_name(rs.getString("father_name"));
            studentDto.setSurename(rs.getString("surename"));
            studentDto.setAge(rs.getInt("age"));
            studentDto.setFees(rs.getFloat("fees"));
            studentDto.setStream(rs.getString("stream"));
            studentDto.setYear(rs.getInt("year"));
            studentDto.setSid(rs.getLong("sid"));
            studentDtos.add(studentDto);
        }
        con.close();
        return studentDtos;
    }

}
