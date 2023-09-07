package com.example.demo.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "risposte")
@Getter
@Setter
@NoArgsConstructor
public class Risposta{
	@Id
	@GeneratedValue
	private UUID id;
	private String text;
	private boolean isCorrect;
	@ManyToOne
	private Domanda question;

	public Risposta(String text, boolean isCorrect, Domanda question) {
		this.text = text;
		this.isCorrect = isCorrect;
		this.question = question;
	}
}