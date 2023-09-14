package com.example.demo.payload;

import com.example.demo.Level.Level;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RisultatiPayload {
	private int score;
	private Level level;
}
