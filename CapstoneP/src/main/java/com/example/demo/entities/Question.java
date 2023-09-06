package com.example.demo.entities;

import java.util.List;
import java.util.UUID;

import com.example.demo.Level.Level;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "questions")
@Getter
@Setter
@NoArgsConstructor
public class Question {
	@Id
	@GeneratedValue
	private UUID id;
	private String text;
	private Level level;
	private List<Answer> answer;
	private Answer correctAnswer;

	public Question(String text, Level level, List<Answer> answer, Answer correctAnswer) {
		this.text = text;
		this.level= level;
		this.answer = answer;
		this.correctAnswer = correctAnswer;
	    }
}
