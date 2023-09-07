package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.Level.Level;
import com.example.demo.Repository.AnswerRepository;
import com.example.demo.Repository.QuestionRepository;
import com.example.demo.Service.AnswerService;
import com.example.demo.Service.QuestionService;
import com.example.demo.entities.AnswerN;
import com.example.demo.entities.QuestionN;
import com.example.demo.payload.AnswerPayload;
import com.example.demo.payload.QuestionPayload;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	AnswerRepository aRepository;

	@Autowired
	AnswerService aService;

	@Autowired
	QuestionRepository uesRepository;

	@Autowired
	QuestionService uesService;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		QuestionPayload QuestionPay1 = new QuestionPayload("Shark is?", Level.DIFFICILE);
		QuestionN dom1 = uesService.save(QuestionPay1);

		AnswerPayload aPay1 = new AnswerPayload("Shark t", false, dom1);
		AnswerPayload aPay2 = new AnswerPayload("Shark b", true, dom1);
		AnswerPayload aPay3 = new AnswerPayload("Shark a", false, dom1);
		AnswerPayload aPay4 = new AnswerPayload("Shark c", true, dom1);

		AnswerN a1 = aService.save(aPay1);
		AnswerN a2 = aService.save(aPay2);
		AnswerN a3 = aService.save(aPay3);
		AnswerN a4 = aService.save(aPay4);
	}

}
