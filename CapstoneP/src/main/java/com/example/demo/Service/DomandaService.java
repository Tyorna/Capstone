package com.example.demo.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
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

		// crea variabile che tiene punto size.
		// Metterle in un ciclo.
		// Pusharli su un altra lista.
		return qRepository.findByLevel(level);
		// Dammi la size e da uesta seleziona random il numero che ti dico di elementi
		// Prendine una casuale e rifallo senza tenerne una.
	}

	public List<Domanda> findAllByLevelRandomly(Level level) {
		List<Domanda> questionsByLevel = qRepository.findByLevel(level);
		if (questionsByLevel.isEmpty()) {
			return questionsByLevel;
		}
		Random rnd = new Random();
		Set<Integer> indiceTrovato = new HashSet<>();
		List<Domanda> DomandeCasuali = new ArrayList<>();
		for (int i = 0; i < questionsByLevel.size(); i++) {
			int indice = rnd.nextInt(questionsByLevel.size());
			if (!indiceTrovato.contains(indice)) {
				indiceTrovato.add(indice);
				DomandeCasuali.add(questionsByLevel.get(indice));
			}
		}

		return DomandeCasuali;
	}
}
