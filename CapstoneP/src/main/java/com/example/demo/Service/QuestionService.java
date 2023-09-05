package com.example.demo.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.QuestionRepository;
import com.example.demo.entities.Question;
import com.example.demo.payload.QuestionPayload;

@Service
public class QuestionService {
	@Autowired
	QuestionRepository qRepository;

	public Question save(QuestionPayload body) {
		Question newUser = new Question(body.getText(), body.getLevel(), body.getAnswer(), body.getCorrectAnswer());
		return qRepository.save(newUser);
	}

	public List<Question> getUsers() {
		return qRepository.findAll();
	}

	public Page<Question> find(int page, int size, String sort) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(sort));

		return qRepository.findAll(pageable);
	}

	public Optional<Question> findById(UUID id) {
		return qRepository.findById(id);
	}
}
