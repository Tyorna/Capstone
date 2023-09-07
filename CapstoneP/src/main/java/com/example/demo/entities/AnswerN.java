package com.example.demo.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "AnswerN")
@Getter
@Setter
@NoArgsConstructor
public class AnswerN {
	@Id
	@GeneratedValue
	private UUID id_answer;
	private String text;
	private boolean isCorrect;
	@ManyToOne
	@JoinColumn(name = "question", referencedColumnName = "id")
	private QuestionN question;

	public AnswerN(String text, boolean isCorrect, QuestionN question) {
		this.text = text;
		this.isCorrect = isCorrect;
		this.question = question;
	}
}