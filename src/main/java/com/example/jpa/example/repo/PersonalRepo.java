package com.example.jpa.example.repo;

import com.example.jpa.example.model.Personal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalRepo extends JpaRepository<Personal, Long> {

}
