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
import com.example.demo.entities.AnswerN;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.payload.AnswerPayload;

@Service
public class AnswerService {
	@Autowired
	AnswerRepository aRepository;

	public AnswerN save(AnswerPayload body) {
		AnswerN newAnswer = new AnswerN(body.getText(), body.isCorrect(), body.getQuestion());
		return aRepository.save(newAnswer);
	}

	public List<AnswerN> getAnswer() {
		return aRepository.findAll();
	}

	public Page<AnswerN> find(int page, int size, String sort) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(sort));

		return aRepository.findAll(pageable);
	}

	public AnswerN findById(UUID id) throws NotFoundException {
		return aRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
	}

	public AnswerN findByIdAndUpdate(UUID id, AnswerPayload body) throws NotFoundException {
		AnswerN found = this.findById(id);
		found.setText(body.getText());
		found.setCorrect(body.isCorrect());
		found.setQuestion(body.getQuestion());
		return aRepository.save(found);
	}

	public void findByIdAndDelete(UUID id) throws NotFoundException {
		AnswerN found = this.findById(id);
		aRepository.delete(found);
	}
}
