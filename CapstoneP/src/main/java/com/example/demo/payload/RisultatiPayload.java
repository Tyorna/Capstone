package com.example.demo.payload;

import java.util.UUID;

import com.example.demo.Level.Level;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RisultatiPayload {
	private UUID userId;
	private int correctAnswers;
	private double score;
	private Level level;
}
