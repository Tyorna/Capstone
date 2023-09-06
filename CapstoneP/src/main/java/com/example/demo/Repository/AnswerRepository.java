package com.example.demo.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Answer;

public interface AnswerRepository extends JpaRepository<Answer, UUID>{

}
