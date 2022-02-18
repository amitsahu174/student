package com.example.jpa.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "personal_details")
public class Personal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sid;

    private String name;
    private String surename;
    private String father_name;
    private int age;
}
