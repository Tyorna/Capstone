package com.example.demo.entities;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Answer {
	    private String text;
	    private boolean isCorrect;
	    
	    public Answer(String text, boolean isCorrect) {
	        this.text = text;
	        this.isCorrect = isCorrect;
	    }
}
