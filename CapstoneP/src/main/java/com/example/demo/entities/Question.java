package com.example.demo.entities;

import java.util.List;

import com.example.demo.Level.Level;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Question {
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
