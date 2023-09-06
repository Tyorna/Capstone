package com.example.demo.Controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.Service.AnswerService;
import com.example.demo.entities.Answer;
import com.example.demo.payload.AnswerPayload;

public class AnswerController {
	@Autowired
	AnswerService aService;

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Answer saveUser(@RequestBody AnswerPayload body) {
		Answer createdQuestion = aService.save(body);
		return createdQuestion;
	}

	@GetMapping("/{Answerid}")
	public Answer findById(@PathVariable UUID Answerid) {
		return aService.findById(Answerid);
	}
	
	@PutMapping("/{Answerid}")
	public Answer updateUser(@PathVariable UUID AnswerId, @RequestBody AnswerPayload body) {
		return aService.findByIdAndUpdate(AnswerId, body);
	}

	@DeleteMapping("/{AnswerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable UUID AnswerId) {
		aService.findByIdAndDelete(AnswerId);
	}
}
