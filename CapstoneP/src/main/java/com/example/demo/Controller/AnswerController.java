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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.AnswerService;
import com.example.demo.entities.AnswerN;
import com.example.demo.payload.AnswerPayload;

@RestController
@RequestMapping("/answers")
public class AnswerController {
	@Autowired
	AnswerService aService;

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public AnswerN saveUser(@RequestBody AnswerPayload body) {
		AnswerN createdQuestion = aService.save(body);
		return createdQuestion;
	}

	@GetMapping("/{Answerid}")
	public AnswerN findById(@PathVariable UUID Answerid) {
		return aService.findById(Answerid);
	}

	@PutMapping("/{Answerid}")
	public AnswerN updateUser(@PathVariable UUID AnswerId, @RequestBody AnswerPayload body) {
		return aService.findByIdAndUpdate(AnswerId, body);
	}

	@DeleteMapping("/{AnswerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable UUID AnswerId) {
		aService.findByIdAndDelete(AnswerId);
	}
}
