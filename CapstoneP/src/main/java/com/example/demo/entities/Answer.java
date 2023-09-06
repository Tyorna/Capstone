package com.example.demo.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "answers")
@Getter
@Setter
@NoArgsConstructor
public class Answer {
	@Id
	@GeneratedValue
	private UUID id;
	private String text;
	private boolean isCorrect;
	    
	public Answer(String text, boolean isCorrect) {
		this.text = text;
		this.isCorrect = isCorrect;
	    }
}
