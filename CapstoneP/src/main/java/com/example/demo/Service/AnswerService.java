package com.example.demo.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.AnswerRepository;
import com.example.demo.entities.Answer;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.payload.AnswerPayload;

@Service
public class AnswerService {
	@Autowired
	AnswerRepository aRepository;

	public Answer save(AnswerPayload body) {
		Answer newAnswer = new Answer(body.getText(), body.isCorrect());
		return aRepository.save(newAnswer);
	}

	public List<Answer> getAnswer() {
		return aRepository.findAll();
	}

	public Page<Answer> find(int page, int size, String sort) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(sort));

		return aRepository.findAll(pageable);
	}

	public Answer findById(UUID id) throws NotFoundException {
		return aRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
	}

	public Answer findByIdAndUpdate(UUID id, AnswerPayload body) throws NotFoundException {
		Answer found = this.findById(id);
		found.setText(body.getText());
		found.setCorrect(body.isCorrect());
		return aRepository.save(found);
	}

	public void findByIdAndDelete(UUID id) throws NotFoundException {
		Answer found = this.findById(id);
		aRepository.delete(found);
	}
}
