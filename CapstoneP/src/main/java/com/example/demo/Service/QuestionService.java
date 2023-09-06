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
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.payload.QuestionPayload;

@Service
public class QuestionService {
	@Autowired
	QuestionRepository qRepository;

	public Question save(QuestionPayload body) {
		Question newQuestion = new Question(body.getText(), body.getLevel(), body.getAnswer(), body.getCorrectAnswer());
		return qRepository.save(newQuestion);
	}

	public List<Question> getQuestions() {
		return qRepository.findAll();
	}

	public Page<Question> find(int page, int size, String sort) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(sort));

		return qRepository.findAll(pageable);
	}

	public Question findById(UUID id) throws NotFoundException {
		return qRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
	}

	public Question findByIdAndUpdate(UUID id, QuestionPayload body) throws NotFoundException {
		Question found = this.findById(id);
		found.setText(body.getText());
		found.setLevel(body.getLevel());
		found.setAnswer(body.getAnswer());
		found.setCorrectAnswer(body.getCorrectAnswer());
		return qRepository.save(found);
	}

	public void findByIdAndDelete(UUID id) throws NotFoundException {
		Question found = this.findById(id);
		qRepository.delete(found);
	}
}
