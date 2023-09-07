package com.example.demo.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.QuestionRepository;
import com.example.demo.entities.QuestionN;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.payload.QuestionPayload;

@Service
public class QuestionService {
	@Autowired
	QuestionRepository qRepository;

	public QuestionN save(QuestionPayload body) {
		QuestionN newQuestion = new QuestionN(body.getText(), body.getLevel());
		return qRepository.save(newQuestion);
	}

	public List<QuestionN> getQuestions() {
		return qRepository.findAll();
	}

	public Page<QuestionN> find(int page, int size, String sort) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(sort));

		return qRepository.findAll(pageable);
	}

	public QuestionN findById(UUID id) throws NotFoundException {
		return qRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
	}

	public QuestionN findByIdAndUpdate(UUID id, QuestionPayload body) throws NotFoundException {
		QuestionN found = this.findById(id);
		found.setText(body.getText());
		found.setLevel(body.getLevel());
		return qRepository.save(found);
	}

	public void findByIdAndDelete(UUID id) throws NotFoundException {
		QuestionN found = this.findById(id);
		qRepository.delete(found);
	}
}
