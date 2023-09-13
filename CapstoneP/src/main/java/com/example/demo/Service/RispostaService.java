package com.example.demo.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.RispostaRepository;
import com.example.demo.entities.Risposta;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.payload.RispostaPayload;

@Service
public class RispostaService {
	@Autowired
	RispostaRepository aRepository;

	public Risposta save(RispostaPayload body) {
		Risposta newAnswer = new Risposta(body.getText(), body.getIsCorrect(), body.getQuestion());
		return aRepository.save(newAnswer);
	}

	public List<Risposta> getRisposta() {
		return aRepository.findAll();
	}

	public Page<Risposta> find(int page, int size, String sort) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(sort));

		return aRepository.findAll(pageable);
	}

	public Risposta findById(UUID id) throws NotFoundException {
		return aRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
	}

	public Risposta findByIdAndUpdate(UUID id, RispostaPayload body) throws NotFoundException {
		Risposta found = this.findById(id);
		found.setText(body.getText());
		found.setIsCorrect(body.getIsCorrect());
		found.setQuestion(body.getQuestion());
		return aRepository.save(found);
	}

	public void findByIdAndDelete(UUID id) throws NotFoundException {
		Risposta found = this.findById(id);
		aRepository.delete(found);
	}
}
