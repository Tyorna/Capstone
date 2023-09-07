package com.example.demo.payload;

import com.example.demo.entities.QuestionN;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AnswerPayload {
	String text;
	boolean isCorrect;
	private QuestionN question;
}
