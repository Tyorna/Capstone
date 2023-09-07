package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.Level.Level;
import com.example.demo.Repository.DomandaRepository;
import com.example.demo.Repository.RispostaRepository;
import com.example.demo.Service.DomandaService;
import com.example.demo.Service.RispostaService;
import com.example.demo.entities.Domanda;
import com.example.demo.entities.Risposta;
import com.example.demo.payload.DomandaPayload;
import com.example.demo.payload.RispostaPayload;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	RispostaRepository aRepository;

	@Autowired
	RispostaService aService;

	@Autowired
	DomandaRepository dRepository;

	@Autowired
	DomandaService dService;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		DomandaPayload QuestionPay1 = new DomandaPayload("Shark is?", Level.DIFFICILE);
		Domanda dom1 = dService.save(QuestionPay1);

		RispostaPayload aPay1 = new RispostaPayload("Shark t", false, dom1);
		RispostaPayload aPay2 = new RispostaPayload("Shark b", true, dom1);
		RispostaPayload aPay3 = new RispostaPayload("Shark a", false, dom1);
		RispostaPayload aPay4 = new RispostaPayload("Shark c", true, dom1);

		Risposta a1 = aService.save(aPay1);
		Risposta a2 = aService.save(aPay2);
		Risposta a3 = aService.save(aPay3);
		Risposta a4 = aService.save(aPay4);
	}

}
