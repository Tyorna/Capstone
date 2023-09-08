package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.example.demo.Level.Level;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "domande")
@Getter
@Setter
@NoArgsConstructor
public class Domanda {
	@Id
	@GeneratedValue
	private UUID id;
	private String text;
	@Enumerated(EnumType.STRING)
	private Level level;
	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
	private List<Risposta> answers = new ArrayList<>();

	public Domanda(String text, Level level) {
		this.text = text;
		this.level = level;
	}
}
