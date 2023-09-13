package com.example.demo.payload;

import com.example.demo.entities.Domanda;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RispostaPayload {
	String text;
	int isCorrect;
	private Domanda question;
}
