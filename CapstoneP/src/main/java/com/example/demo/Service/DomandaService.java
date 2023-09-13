package com.example.demo.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Level.Level;
import com.example.demo.Repository.DomandaRepository;
import com.example.demo.entities.Domanda;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.payload.DomandaPayload;

@Service
public class DomandaService {
	@Autowired
	DomandaRepository qRepository;

	public Domanda save(DomandaPayload body) {
		Domanda newQuestion = new Domanda(body.getText(), body.getLevel());
		return qRepository.save(newQuestion);
	}

	public List<Domanda> getDomande() {
		return qRepository.findAll();
	}

	public Page<Domanda> find(int page, int size, String sort) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(sort));

		return qRepository.findAll(pageable);
	}

	public Domanda findById(UUID id) throws NotFoundException {
		return qRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
	}

	public Domanda findByIdAndUpdate(UUID id, DomandaPayload body) {
		Domanda found = this.findById(id);
		found.setText(body.getText());
		found.setLevel(body.getLevel());
		return qRepository.save(found);
	}

	public void findByIdAndDelete(UUID id) {
		Domanda found = this.findById(id);
		qRepository.delete(found);
	}

	public List<Domanda> findByLevel(Level level) {
		return qRepository.findByLevel(level);
	}
}
