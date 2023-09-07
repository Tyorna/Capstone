package com.example.demo.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.AnswerN;

public interface AnswerRepository extends JpaRepository<AnswerN, UUID> {

}
