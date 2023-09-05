package com.example.demo.payload;

import java.util.List;

import com.example.demo.Level.Level;
import com.example.demo.entities.Answer;

import lombok.Getter;

@Getter
public class QuestionPayload {
	String text;
    private Level level;
    List<Answer> answer;
    Answer correctAnswer;
}
