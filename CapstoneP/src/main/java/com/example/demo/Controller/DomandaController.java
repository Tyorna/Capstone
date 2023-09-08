package com.example.demo.Controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.DomandaService;
import com.example.demo.entities.Domanda;
import com.example.demo.payload.DomandaPayload;

@RestController
@RequestMapping("/domande")
public class DomandaController {

	@Autowired
	DomandaService qService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Domanda saveQuestion(@RequestBody DomandaPayload body) {
		Domanda createdQuestion = qService.save(body);
		return createdQuestion;
	}

	@GetMapping
	public Page<Domanda> getDomande(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy) {
		return qService.find(page, size, sortBy);
	}

	@GetMapping("/{DomandaId}")
	public Domanda findById(@PathVariable UUID DomandaId) {
		return qService.findById(DomandaId);
	}

	@PutMapping("/{DomandaId}")
	public Domanda updateUser(@PathVariable UUID DomandaId, @RequestBody DomandaPayload body) {
		return qService.findByIdAndUpdate(DomandaId, body);
	}

	@DeleteMapping("/{DomandaId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable UUID DomandaId) {
		qService.findByIdAndDelete(DomandaId);
	}
}
