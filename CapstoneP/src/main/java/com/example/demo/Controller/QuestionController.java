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

import com.example.demo.Service.QuestionService;
import com.example.demo.entities.QuestionN;
import com.example.demo.payload.QuestionPayload;

@RestController
@RequestMapping("/questions")
public class QuestionController {

		@Autowired
		QuestionService qService;

		@PostMapping("")
		@ResponseStatus(HttpStatus.CREATED)
		public QuestionN saveUser(@RequestBody QuestionPayload body) {
			QuestionN createdQuestion = qService.save(body);
			return createdQuestion;
		}

		@GetMapping("/{id}")
		public QuestionN findById(@PathVariable UUID id) {
			return qService.findById(id);
		}
		
		@PutMapping("/{id}")
		public QuestionN  updateUser(@PathVariable UUID id, @RequestBody QuestionPayload body) {
			return qService.findByIdAndUpdate(id, body);
		}

		@DeleteMapping("/{id}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void deleteUser(@PathVariable UUID id) {
			qService.findByIdAndDelete(id);
		}
}
