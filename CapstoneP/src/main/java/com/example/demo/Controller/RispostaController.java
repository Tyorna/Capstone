package com.example.demo.Controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.RispostaService;
import com.example.demo.entities.Risposta;
import com.example.demo.payload.RispostaPayload;

@RestController
@RequestMapping("/risposte")
public class RispostaController {
	@Autowired
	RispostaService aService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Risposta saveRisposte(@RequestBody RispostaPayload body) {
		Risposta createdQuestion = aService.save(body);
		return createdQuestion;
	}

	@GetMapping("")
	public void getRisposteT() {
		aService.getRisposte();
	}

	@GetMapping("/{RispostaId}")
	public Risposta findById(@PathVariable UUID RispostaId) {
		return aService.findById(RispostaId);
	}

	@PutMapping("/{RispostaId}")
	public Risposta updateRisposte(@PathVariable UUID RispostaId, @RequestBody RispostaPayload body) {
		return aService.findByIdAndUpdate(RispostaId, body);
	}

	@DeleteMapping("/{RispostaId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteRisposte(@PathVariable UUID RispostaId) {
		aService.findByIdAndDelete(RispostaId);
	}
}
