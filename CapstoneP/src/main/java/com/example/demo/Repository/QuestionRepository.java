package com.example.demo.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.QuestionN;

public interface QuestionRepository extends JpaRepository<QuestionN, UUID>{

}
