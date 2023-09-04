package com.example.demo.entities;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Question {
	    private String text;
	    private List<Answer> answer;
	    private Answer correctAnswer;

	    public Question(String text, List<Answer> answer, Answer correctAnswer) {
	        this.text = text;
	        this.answer = answer;
	        this.correctAnswer = correctAnswer;
	    }
}
