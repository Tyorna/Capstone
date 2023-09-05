package com.example.demo.Controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.QuestionService;
import com.example.demo.entities.Question;
import com.example.demo.payload.QuestionPayload;

@RestController
@RequestMapping("/questions")
public class QuestionController {

		@Autowired
		QuestionService qService;

		@PostMapping("")
		@ResponseStatus(HttpStatus.CREATED)
		public Question saveUser(@RequestBody QuestionPayload body) {
			Question createdQuestion = qService.save(body);
			return createdQuestion;
		}

		@GetMapping("/{id}")
		public Optional<Question> findById(@PathVariable UUID id) {
			return qService.findById(id);
		}
}
