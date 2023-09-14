package com.example.demo.Service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.RisultatiRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.entities.Risultati;
import com.example.demo.entities.User;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.payload.RisultatiPayload;

@Service
public class RisultatiService {
	@Autowired
	private RisultatiRepository risultatiRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	public Risultati saveRisultati(RisultatiPayload body, UUID userId) {
		User user = userService.findById(userId);
		if (user != null) {
			LocalDateTime timestamp = LocalDateTime.now();
			Risultati Risultati = new Risultati(user, body.getScore(), timestamp, body.getLevel());

			return risultatiRepository.save(Risultati);
		}

		return null;
	}

	public Risultati getRisultatiById(UUID id) throws NotFoundException {
		return risultatiRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
	}

	public Risultati findByIdAndUpdate(UUID id, RisultatiPayload body) {
		Risultati found = this.getRisultatiById(id);
		found.setScore(body.getScore());
		found.setLevel(body.getLevel());
		found.setTimestamp(LocalDateTime.now());
		found.setUser(found.getUser());
		return risultatiRepository.save(found);
	}

	public void findByIdAndDelete(UUID id) {
		Risultati found = this.getRisultatiById(id);
		risultatiRepository.delete(found);
	}

}
