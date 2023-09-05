package com.example.demo.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Question;

public interface QuestionRepository extends JpaRepository<Question, UUID>{

}
