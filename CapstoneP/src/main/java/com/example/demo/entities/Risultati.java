package com.example.demo.entities;

import java.time.LocalDateTime; // Import for date and time
import java.util.UUID;

import com.example.demo.Level.Level;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "risultati")
@Getter
@Setter
@NoArgsConstructor
public class Risultati {
	@Id
	@GeneratedValue
	private UUID id;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	@JsonIgnore
	private User user;
	private int correctAnswers;
	private double score;
	@Enumerated(EnumType.STRING)
	private Level level;
	private LocalDateTime timestamp;

	public Risultati(User user, int correctAnswers, double score, LocalDateTime timestamp, Level level) {
		this.user = user;
		this.correctAnswers = correctAnswers;
		this.score = score;
		this.timestamp = timestamp;
		this.level = level;
	}
}
