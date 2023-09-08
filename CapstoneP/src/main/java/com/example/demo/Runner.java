package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.Repository.DomandaRepository;
import com.example.demo.Repository.RispostaRepository;
import com.example.demo.Service.DomandaService;
import com.example.demo.Service.RispostaService;

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

//		// Uno
//		DomandaPayload QuestionPay1 = new DomandaPayload("How many species of sharks are there?", Level.BASE);
//		Domanda dom1 = dService.save(QuestionPay1);
//
//		RispostaPayload aPay1 = new RispostaPayload("About 40", false, dom1);
//		RispostaPayload aPay2 = new RispostaPayload("About 100", false, dom1);
//		RispostaPayload aPay3 = new RispostaPayload("About 500", true, dom1);
//		RispostaPayload aPay4 = new RispostaPayload("About 900", false, dom1);
//
//		Risposta a1 = aService.save(aPay1);
//		Risposta a2 = aService.save(aPay2);
//		Risposta a3 = aService.save(aPay3);
//		Risposta a4 = aService.save(aPay4);
//
//		// Due
//		DomandaPayload QuestionPay2 = new DomandaPayload("For how many years they have been inhabiting our planet?",
//				Level.BASE);
//		Domanda dom2 = dService.save(QuestionPay2);
//
//		RispostaPayload aPay5 = new RispostaPayload("About 40 milions years", false, dom2);
//		RispostaPayload aPay6 = new RispostaPayload("About 100 milions years", false, dom2);
//		RispostaPayload aPay7 = new RispostaPayload("About 300 milions years", false, dom2);
//		RispostaPayload aPay8 = new RispostaPayload("About 450 milions years", true, dom2);
//
//		Risposta a5 = aService.save(aPay5);
//		Risposta a6 = aService.save(aPay6);
//		Risposta a7 = aService.save(aPay7);
//		Risposta a8 = aService.save(aPay8);
//
//		// Tre
//		DomandaPayload QuestionPay3 = new DomandaPayload("Which one has the longest lifespan??", Level.BASE);
//		Domanda dom3 = dService.save(QuestionPay3);
//
//		RispostaPayload aPay9 = new RispostaPayload("The great white shark (Carcharodon carcharias) ", false, dom3);
//		RispostaPayload aPay10 = new RispostaPayload("The Greenland shark (Somniosus microcephalus)", true, dom3);
//		RispostaPayload aPay11 = new RispostaPayload("The common thresher (Alopias vulpinus)", false, dom3);
//		RispostaPayload aPay12 = new RispostaPayload("The scalloped hammerhead (Sphyrna lewini)", false, dom3);
//
//		Risposta a9 = aService.save(aPay9);
//		Risposta a10 = aService.save(aPay10);
//		Risposta a11 = aService.save(aPay11);
//		Risposta a12 = aService.save(aPay12);
//
//		// 4
//		DomandaPayload QuestionPay4 = new DomandaPayload("Which shark is the longest?", Level.BASE);
//		Domanda dom4 = dService.save(QuestionPay3);
//
//		RispostaPayload aPay13 = new RispostaPayload("The whale shark (Rhincodon typus)", true, dom4);
//		RispostaPayload aPay14 = new RispostaPayload("The basking shark (Cetorhinus maximus)", false, dom4);
//		RispostaPayload aPay15 = new RispostaPayload("The great white shark (Carcharodon carcharias)", false, dom4);
//		RispostaPayload aPay16 = new RispostaPayload("The tiger shark (Galeocerdo cuvier)", false, dom4);
//
//		Risposta a13 = aService.save(aPay13);
//		Risposta a14 = aService.save(aPay14);
//		Risposta a15 = aService.save(aPay15);
//		Risposta a16 = aService.save(aPay16);
//
//		// 5
//		DomandaPayload QuestionPay5 = new DomandaPayload("Who do prey on sharks ??", Level.BASE);
//		Domanda dom5 = dService.save(QuestionPay5);
//
//		RispostaPayload aPay17 = new RispostaPayload("TBD", false, dom5);
//		RispostaPayload aPay18 = new RispostaPayload("No one", false, dom5);
//		RispostaPayload aPay19 = new RispostaPayload("The orca (Orcinus orca)", true, dom5);
//		RispostaPayload aPay20 = new RispostaPayload("TBD", true, dom5);
//
//		Risposta a17 = aService.save(aPay17);
//		Risposta a18 = aService.save(aPay18);
//		Risposta a19 = aService.save(aPay19);
//		Risposta a20 = aService.save(aPay20);
//
//		// Sei
//		DomandaPayload QuestionPay6 = new DomandaPayload("In sharks the skeleton is: ", Level.BASE);
//		Domanda dom6 = dService.save(QuestionPay6);
//
//		RispostaPayload aPay21 = new RispostaPayload("Bone", false, dom3);
//		RispostaPayload aPay22 = new RispostaPayload("Cartilaginous", true, dom3);
//
//		Risposta a21 = aService.save(aPay21);
//		Risposta a22 = aService.save(aPay22);
//
//		// 7
//		DomandaPayload QuestionPay7 = new DomandaPayload("Sharks only live in salt waters?", Level.BASE);
//		Domanda dom7 = dService.save(QuestionPay7);
//
//		RispostaPayload aPay25 = new RispostaPayload("True", false, dom7);
//		RispostaPayload aPay26 = new RispostaPayload("False", true, dom7);
//
//		Risposta a25 = aService.save(aPay25);
//		Risposta a26 = aService.save(aPay26);
//
//		// Otto
//		DomandaPayload QuestionPay8 = new DomandaPayload("What is the main sense sharks use to locate prey?",
//				Level.BASE);
//		Domanda dom8 = dService.save(QuestionPay8);
//
//		RispostaPayload aPay29 = new RispostaPayload("Hearing", false, dom8);
//		RispostaPayload aPay30 = new RispostaPayload("Smell", true, dom8);
//		RispostaPayload aPay31 = new RispostaPayload("Sight", false, dom8);
//		RispostaPayload aPay32 = new RispostaPayload("Taste", false, dom8);
//
//		Risposta a29 = aService.save(aPay29);
//		Risposta a30 = aService.save(aPay30);
//		Risposta a31 = aService.save(aPay31);
//		Risposta a32 = aService.save(aPay31);
//
//		// Nove
//		DomandaPayload QuestionPay9 = new DomandaPayload(
//				"Which shark species is known for its distinctive black tips on its fins?", Level.BASE);
//		Domanda dom9 = dService.save(QuestionPay9);
//
//		RispostaPayload aPay33 = new RispostaPayload("Bull Shark", false, dom9);
//		RispostaPayload aPay34 = new RispostaPayload("Hammerhead Shark", false, dom9);
//		RispostaPayload aPay35 = new RispostaPayload("Lemon Shark", false, dom9);
//		RispostaPayload aPay36 = new RispostaPayload("Blacktip Shark", true, dom9);
//
//		Risposta a33 = aService.save(aPay33);
//		Risposta a34 = aService.save(aPay34);
//		Risposta a35 = aService.save(aPay35);
//		Risposta a36 = aService.save(aPay36);
//
//		// Dieci
//		DomandaPayload QuestionPay10 = new DomandaPayload(
//				"What is the term for the special sensory organs that some sharks "
//						+ "have on their snouts, allowing them to detect electric fields produced by other animals?",
//				Level.BASE);
//		Domanda dom10 = dService.save(QuestionPay10);
//
//		RispostaPayload aPay37 = new RispostaPayload("Electrostatic organs", false, dom10);
//		RispostaPayload aPay38 = new RispostaPayload("Electric fins", false, dom10);
//		RispostaPayload aPay39 = new RispostaPayload("Ampullae of Lorenzini", true, dom10);
//		RispostaPayload aPay40 = new RispostaPayload("Shock sensors", false, dom10);
//
//		Risposta a37 = aService.save(aPay37);
//		Risposta a38 = aService.save(aPay38);
//		Risposta a39 = aService.save(aPay39);
//		Risposta a40 = aService.save(aPay40);
//
//		// Undici
//		DomandaPayload QuestionPay11 = new DomandaPayload("What is the primary function of a shark's dorsal fin?",
//				Level.BASE);
//		Domanda dom11 = dService.save(QuestionPay11);
//
//		RispostaPayload aPay41 = new RispostaPayload("Stability and balance", true, dom11);
//		RispostaPayload aPay42 = new RispostaPayload("Steering", false, dom11);
//		RispostaPayload aPay43 = new RispostaPayload("Propulsion", false, dom11);
//		RispostaPayload aPay44 = new RispostaPayload("Capturing prey", false, dom11);
//
//		Risposta a41 = aService.save(aPay41);
//		Risposta a42 = aService.save(aPay42);
//		Risposta a43 = aService.save(aPay43);
//		Risposta a44 = aService.save(aPay44);

	}

}
