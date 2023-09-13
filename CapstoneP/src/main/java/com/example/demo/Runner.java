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

		// UnoB
		DomandaPayload QuestionPay1 = new DomandaPayload("How many species of sharks are there?", Level.BASE);
		Domanda dom1 = dService.save(QuestionPay1);

		RispostaPayload aPay1 = new RispostaPayload("About 40", false, dom1);
		RispostaPayload aPay2 = new RispostaPayload("About 100", false, dom1);
		RispostaPayload aPay3 = new RispostaPayload("About 500", true, dom1);
		RispostaPayload aPay4 = new RispostaPayload("About 900", false, dom1);

		Risposta a1 = aService.save(aPay1);
		Risposta a2 = aService.save(aPay2);
		Risposta a3 = aService.save(aPay3);
		Risposta a4 = aService.save(aPay4);

		// Due
		DomandaPayload QuestionPay2 = new DomandaPayload("For how many years they have been inhabiting our planet?",
				Level.BASE);
		Domanda dom2 = dService.save(QuestionPay2);

		RispostaPayload aPay5 = new RispostaPayload("About 40 milions years", false, dom2);
		RispostaPayload aPay6 = new RispostaPayload("About 100 milions years", false, dom2);
		RispostaPayload aPay7 = new RispostaPayload("About 300 milions years", false, dom2);
		RispostaPayload aPay8 = new RispostaPayload("About 450 milions years", true, dom2);

		Risposta a5 = aService.save(aPay5);
		Risposta a6 = aService.save(aPay6);
		Risposta a7 = aService.save(aPay7);
		Risposta a8 = aService.save(aPay8);

		// Tre
		DomandaPayload QuestionPay3 = new DomandaPayload("Which one has the longest lifespan??", Level.BASE);
		Domanda dom3 = dService.save(QuestionPay3);

		RispostaPayload aPay9 = new RispostaPayload("The great white shark (Carcharodon carcharias) ", false, dom3);
		RispostaPayload aPay10 = new RispostaPayload("The Greenland shark (Somniosus microcephalus)", true, dom3);
		RispostaPayload aPay11 = new RispostaPayload("The common thresher (Alopias vulpinus)", false, dom3);
		RispostaPayload aPay12 = new RispostaPayload("The scalloped hammerhead (Sphyrna lewini)", false, dom3);

		Risposta a9 = aService.save(aPay9);
		Risposta a10 = aService.save(aPay10);
		Risposta a11 = aService.save(aPay11);
		Risposta a12 = aService.save(aPay12);

		// 4
		DomandaPayload QuestionPay4 = new DomandaPayload("Which shark is the longest?", Level.BASE);
		Domanda dom4 = dService.save(QuestionPay4);

		RispostaPayload aPay13 = new RispostaPayload("The whale shark (Rhincodon typus)", true, dom4);
		RispostaPayload aPay14 = new RispostaPayload("The basking shark (Cetorhinus maximus)", false, dom4);
		RispostaPayload aPay15 = new RispostaPayload("The great white shark (Carcharodon carcharias)", false, dom4);
		RispostaPayload aPay16 = new RispostaPayload("The tiger shark (Galeocerdo cuvier)", false, dom4);

		Risposta a13 = aService.save(aPay13);
		Risposta a14 = aService.save(aPay14);
		Risposta a15 = aService.save(aPay15);
		Risposta a16 = aService.save(aPay16);

		// 5
		DomandaPayload QuestionPay5 = new DomandaPayload("Who do prey on sharks ??", Level.BASE);
		Domanda dom5 = dService.save(QuestionPay5);

		RispostaPayload aPay17 = new RispostaPayload("TBD", false, dom5);
		RispostaPayload aPay18 = new RispostaPayload("No one", false, dom5);
		RispostaPayload aPay19 = new RispostaPayload("The orca (Orcinus orca)", true, dom5);
		RispostaPayload aPay20 = new RispostaPayload("TBD", true, dom5);

		Risposta a17 = aService.save(aPay17);
		Risposta a18 = aService.save(aPay18);
		Risposta a19 = aService.save(aPay19);
		Risposta a20 = aService.save(aPay20);

		// Sei
		DomandaPayload QuestionPay6 = new DomandaPayload("In sharks the skeleton is: ", Level.BASE);
		Domanda dom6 = dService.save(QuestionPay6);

		RispostaPayload aPay21 = new RispostaPayload("Bone", false, dom6);
		RispostaPayload aPay22 = new RispostaPayload("Cartilaginous", true, dom6);

		Risposta a21 = aService.save(aPay21);
		Risposta a22 = aService.save(aPay22);

		// 7
		DomandaPayload QuestionPay7 = new DomandaPayload("Sharks only live in salt waters?", Level.BASE);
		Domanda dom7 = dService.save(QuestionPay7);

		RispostaPayload aPay25 = new RispostaPayload("True", false, dom7);
		RispostaPayload aPay26 = new RispostaPayload("False", true, dom7);

		Risposta a25 = aService.save(aPay25);
		Risposta a26 = aService.save(aPay26);

		// Otto
		DomandaPayload QuestionPay8 = new DomandaPayload("What is the main sense sharks use to locate prey?",
				Level.BASE);
		Domanda dom8 = dService.save(QuestionPay8);

		RispostaPayload aPay29 = new RispostaPayload("Hearing", false, dom8);
		RispostaPayload aPay30 = new RispostaPayload("Smell", true, dom8);
		RispostaPayload aPay31 = new RispostaPayload("Sight", false, dom8);
		RispostaPayload aPay32 = new RispostaPayload("Taste", false, dom8);

		Risposta a29 = aService.save(aPay29);
		Risposta a30 = aService.save(aPay30);
		Risposta a31 = aService.save(aPay31);
		Risposta a32 = aService.save(aPay31);

		// Nove
		DomandaPayload QuestionPay9 = new DomandaPayload(
				"Which shark species is known for its distinctive black tips on its fins?", Level.BASE);
		Domanda dom9 = dService.save(QuestionPay9);

		RispostaPayload aPay33 = new RispostaPayload("The bull shark (Carcharhinus leucas)", false, dom9);
		RispostaPayload aPay34 = new RispostaPayload("Hammerhead Shark", false, dom9);
		RispostaPayload aPay35 = new RispostaPayload("Lemon Shark", false, dom9);
		RispostaPayload aPay36 = new RispostaPayload("The blacktip reef shark (Carcharhinus melanopterus)", true, dom9);

		Risposta a33 = aService.save(aPay33);
		Risposta a34 = aService.save(aPay34);
		Risposta a35 = aService.save(aPay35);
		Risposta a36 = aService.save(aPay36);

		// Dieci
		DomandaPayload QuestionPay10 = new DomandaPayload(
				"What is the term for the special sensory organs that some sharks "
						+ "have on their snouts, allowing them to detect electric fields produced by other animals?",
				Level.BASE);
		Domanda dom10 = dService.save(QuestionPay10);

		RispostaPayload aPay37 = new RispostaPayload("Electrostatic organs", false, dom10);
		RispostaPayload aPay38 = new RispostaPayload("Electric fins", false, dom10);
		RispostaPayload aPay39 = new RispostaPayload("Ampullae of Lorenzini", true, dom10);
		RispostaPayload aPay40 = new RispostaPayload("Shock sensors", false, dom10);

		Risposta a37 = aService.save(aPay37);
		Risposta a38 = aService.save(aPay38);
		Risposta a39 = aService.save(aPay39);
		Risposta a40 = aService.save(aPay40);

		// Undici
		DomandaPayload QuestionPay11 = new DomandaPayload("What is the primary function of a shark's dorsal fin?",
				Level.BASE);
		Domanda dom11 = dService.save(QuestionPay11);

		RispostaPayload aPay41 = new RispostaPayload("Stability and balance", true, dom11);
		RispostaPayload aPay42 = new RispostaPayload("Steering", false, dom11);
		RispostaPayload aPay43 = new RispostaPayload("Propulsion", false, dom11);
		RispostaPayload aPay44 = new RispostaPayload("Capturing prey", false, dom11);

		Risposta a41 = aService.save(aPay41);
		Risposta a42 = aService.save(aPay42);
		Risposta a43 = aService.save(aPay43);
		Risposta a44 = aService.save(aPay44);

		// UnoM
		DomandaPayload QuestionM1 = new DomandaPayload(
				"What is the scientific name for the smallest known shark species?", Level.MEDIO);
		Domanda domM1 = dService.save(QuestionM1);

		RispostaPayload bPay1 = new RispostaPayload("Squaliolus laticaudus", true, domM1);
		RispostaPayload bPay2 = new RispostaPayload("Tinyus sharkus", false, domM1);
		RispostaPayload bPay3 = new RispostaPayload("Miniatus miniatum", false, domM1);
		RispostaPayload bPay4 = new RispostaPayload("Microsharkus microscopium", false, domM1);

		Risposta b1 = aService.save(bPay1);
		Risposta b2 = aService.save(bPay2);
		Risposta b3 = aService.save(bPay3);
		Risposta b4 = aService.save(bPay4);

		// DueM
		DomandaPayload QuestionM2 = new DomandaPayload(
				"What is the term for the process of a shark shedding and replacing its teeth throughout its lifetime?",
				Level.MEDIO);
		Domanda domM2 = dService.save(QuestionM2);

		RispostaPayload bPay5 = new RispostaPayload("Toothache", false, domM2);
		RispostaPayload bPay6 = new RispostaPayload("Polyphyodonty", true, domM2);
		RispostaPayload bPay7 = new RispostaPayload("Dentition", false, domM2);
		RispostaPayload bPay8 = new RispostaPayload("Sharkodontia", false, domM2);

		Risposta b5 = aService.save(bPay5);
		Risposta b6 = aService.save(bPay6);
		Risposta b7 = aService.save(bPay7);
		Risposta b8 = aService.save(bPay8);

		// TreM
		DomandaPayload QuestionM3 = new DomandaPayload(
				"Which type of shark is known for its distinctive barbels around its mouth?", Level.MEDIO);
		Domanda domM3 = dService.save(QuestionM3);

		RispostaPayload bPay9 = new RispostaPayload("Mako Shark", false, domM3);
		RispostaPayload bPay10 = new RispostaPayload("The bull shark (Carcharhinus leucas)", false, domM3);
		RispostaPayload bPay11 = new RispostaPayload("Nurse Shark", true, domM3);
		RispostaPayload bPay12 = new RispostaPayload("Goblin Shark", false, domM3);

		Risposta b9 = aService.save(bPay9);
		Risposta b10 = aService.save(bPay10);
		Risposta b11 = aService.save(bPay11);
		Risposta b12 = aService.save(bPay12);

		// 4M
		DomandaPayload QuestionM4 = new DomandaPayload("What is the largest species of hammerhead shark called?",
				Level.MEDIO);
		Domanda domM4 = dService.save(QuestionM4);

		RispostaPayload bPay13 = new RispostaPayload("Smooth Hammerhead", false, domM4);
		RispostaPayload bPay14 = new RispostaPayload("Great Hammerhead", true, domM4);
		RispostaPayload bPay15 = new RispostaPayload("Scalloped Hammerhead", false, domM4);
		RispostaPayload bPay16 = new RispostaPayload("Bonnethead", false, domM4);

		Risposta b13 = aService.save(bPay13);
		Risposta b14 = aService.save(bPay14);
		Risposta b15 = aService.save(bPay15);
		Risposta b16 = aService.save(bPay16);

		// 5M
		DomandaPayload QuestionM5 = new DomandaPayload(
				"Which type of shark is often found in both saltwater and freshwater environments?", Level.MEDIO);
		Domanda domM5 = dService.save(QuestionM5);

		RispostaPayload bPay17 = new RispostaPayload("The bull shark (Carcharhinus leucas)", true, domM5);
		RispostaPayload bPay18 = new RispostaPayload("Hammerhead Shark", false, domM5);
		RispostaPayload bPay19 = new RispostaPayload("Great White Shark", false, domM5);
		RispostaPayload bPay20 = new RispostaPayload("The tiger shark", false, domM5);

		Risposta b17 = aService.save(bPay17);
		Risposta b18 = aService.save(bPay18);
		Risposta b19 = aService.save(bPay19);
		Risposta b20 = aService.save(bPay20);

		// SeiM
		DomandaPayload QuestionM6 = new DomandaPayload("Which shark has a reputation as a 'garbage eater'?",
				Level.MEDIO);
		Domanda domM6 = dService.save(QuestionM6);

		RispostaPayload bPay21 = new RispostaPayload("The great white shark (Carcharodon carcharias)", false, domM6);
		RispostaPayload bPay22 = new RispostaPayload("The blacktip reef shark (Carcharhinus melanopterus)", false,
				domM6);
		RispostaPayload bPay23 = new RispostaPayload("The whale shark (Rhincodon typus)", false, domM6);
		RispostaPayload bPay24 = new RispostaPayload("The tiger shark (Galeocerdo cuvier)", true, domM6);

		Risposta b21 = aService.save(bPay21);
		Risposta b22 = aService.save(bPay22);
		Risposta b23 = aService.save(bPay23);
		Risposta b24 = aService.save(bPay24);

		// SetteM
		DomandaPayload QuestionM7 = new DomandaPayload("Which shark is known for leaving perfectly round scars?",
				Level.MEDIO);
		Domanda domM7 = dService.save(QuestionM7);

		RispostaPayload bPay25 = new RispostaPayload("The epaulette shark (Hemiscyllium ocellatum)", false, domM7);
		RispostaPayload bPay26 = new RispostaPayload("The cookiecutter shark (Isistius brasiliensis)", true, domM7);
		RispostaPayload bPay27 = new RispostaPayload("The sandbar shark (Carcharhinus plumbeus)", false, domM7);
		RispostaPayload bPay28 = new RispostaPayload("The leopard shark (Triakis semifasciata)", false, domM7);

		Risposta b25 = aService.save(bPay25);
		Risposta b26 = aService.save(bPay26);
		Risposta b27 = aService.save(bPay27);
		Risposta b28 = aService.save(bPay28);

		// OttoM
		DomandaPayload QuestionM8 = new DomandaPayload("Which shark is known to walk on land?", Level.MEDIO);
		Domanda domM8 = dService.save(QuestionM8);

		RispostaPayload bPay29 = new RispostaPayload("The nurse shark (Ginglymostoma cirratum)", false, domM8);
		RispostaPayload bPay30 = new RispostaPayload("The goblin shark (Mitsukurina owstoni) ", false, domM8);
		RispostaPayload bPay31 = new RispostaPayload("The epaulette shark (Hemiscyllium ocellatum)", true, domM8);
		RispostaPayload bPay32 = new RispostaPayload("The pyjama shark (Poroderma africanum)", false, domM8);

		Risposta b29 = aService.save(bPay29);
		Risposta b30 = aService.save(bPay30);
		Risposta b31 = aService.save(bPay31);
		Risposta b32 = aService.save(bPay32);

		// NoveM
		DomandaPayload QuestionM9 = new DomandaPayload(
				"Which shark uses its tail like a whip to deliver crippling blows to its prey?", Level.MEDIO);
		Domanda domM9 = dService.save(QuestionM9);

		RispostaPayload bPay33 = new RispostaPayload("The blacktip reef shark (Carcharhinus melanopterus)", false,
				domM9);
		RispostaPayload bPay34 = new RispostaPayload("The common thresher (Alopias vulpinus)", true, domM9);
		RispostaPayload bPay35 = new RispostaPayload("The leopard shark (Triakis semifasciata)", false, domM9);
		RispostaPayload bPay36 = new RispostaPayload("The frilled shark (Chlamydoselachus anguineus)", false, domM9);

		Risposta b33 = aService.save(bPay33);
		Risposta b34 = aService.save(bPay34);
		Risposta b35 = aService.save(bPay35);
		Risposta b36 = aService.save(bPay36);

		// DieciM
		DomandaPayload QuestionM10 = new DomandaPayload("What is the primary function of a shark's dorsal fin?",
				Level.MEDIO);
		Domanda domM10 = dService.save(QuestionM10);

		RispostaPayload bPay37 = new RispostaPayload("Stability and balance", true, domM10);
		RispostaPayload bPay38 = new RispostaPayload("Steering", false, domM10);
		RispostaPayload bPay39 = new RispostaPayload("Propulsion", false, domM10);
		RispostaPayload bPay40 = new RispostaPayload("Capturing prey", false, domM10);

		Risposta b37 = aService.save(bPay37);
		Risposta b38 = aService.save(bPay38);
		Risposta b39 = aService.save(bPay39);
		Risposta b40 = aService.save(bPay40);

		// UndiciM
		DomandaPayload QuestionM11 = new DomandaPayload("What is the primary function of a shark's dorsal fin?",
				Level.MEDIO);
		Domanda domM11 = dService.save(QuestionM11);

		RispostaPayload bPay41 = new RispostaPayload("Stability and balance", true, domM11);
		RispostaPayload bPay42 = new RispostaPayload("Steering", false, domM11);
		RispostaPayload bPay43 = new RispostaPayload("Propulsion", false, domM11);
		RispostaPayload bPay44 = new RispostaPayload("Capturing prey", false, domM11);

		Risposta b41 = aService.save(bPay41);
		Risposta b42 = aService.save(bPay42);
		Risposta b43 = aService.save(bPay43);
		Risposta b44 = aService.save(bPay44);

		// UnoD
		DomandaPayload QuestionD1 = new DomandaPayload("What is the primary function of a shark's dorsal fin?",
				Level.MEDIO);
		Domanda domD1 = dService.save(QuestionD1);

		RispostaPayload dPay1 = new RispostaPayload("Stability and balance", true, domD1);
		RispostaPayload dPay2 = new RispostaPayload("Steering", false, domD1);
		RispostaPayload dPay3 = new RispostaPayload("Propulsion", false, domD1);
		RispostaPayload dPay4 = new RispostaPayload("Capturing prey", false, domD1);

		Risposta d1 = aService.save(dPay1);
		Risposta d2 = aService.save(dPay2);
		Risposta d3 = aService.save(dPay3);
		Risposta d4 = aService.save(dPay4);

		// DueD
		DomandaPayload QuestionD2 = new DomandaPayload("What is the primary function of a shark's dorsal fin?",
				Level.MEDIO);
		Domanda domD2 = dService.save(QuestionD2);

		RispostaPayload dPay5 = new RispostaPayload("Stability and balance", true, domD2);
		RispostaPayload dPay6 = new RispostaPayload("Steering", false, domD2);
		RispostaPayload dPay7 = new RispostaPayload("Propulsion", false, domD2);
		RispostaPayload dPay8 = new RispostaPayload("Capturing prey", false, domD2);

		Risposta d5 = aService.save(dPay5);
		Risposta d6 = aService.save(dPay6);
		Risposta d7 = aService.save(dPay7);
		Risposta d8 = aService.save(dPay8);

		// TreD
		DomandaPayload QuestionD3 = new DomandaPayload("What is the primary function of a shark's dorsal fin?",
				Level.MEDIO);
		Domanda domD3 = dService.save(QuestionM3);

		RispostaPayload dPay9 = new RispostaPayload("Stability and balance", true, domD3);
		RispostaPayload dPay10 = new RispostaPayload("Steering", false, domD3);
		RispostaPayload dPay11 = new RispostaPayload("Propulsion", false, domD3);
		RispostaPayload dPay12 = new RispostaPayload("Capturing prey", false, domD3);

		Risposta d9 = aService.save(dPay9);
		Risposta d10 = aService.save(dPay10);
		Risposta d11 = aService.save(dPay11);
		Risposta d12 = aService.save(dPay12);

		// 4D
		DomandaPayload QuestionD4 = new DomandaPayload("What is the primary function of a shark's dorsal fin?",
				Level.MEDIO);
		Domanda domD4 = dService.save(QuestionD4);

		RispostaPayload dPay13 = new RispostaPayload("Stability and balance", true, domD4);
		RispostaPayload dPay14 = new RispostaPayload("Steering", false, domD4);
		RispostaPayload dPay15 = new RispostaPayload("Propulsion", false, domD4);
		RispostaPayload dPay16 = new RispostaPayload("Capturing prey", false, domD4);

		Risposta d13 = aService.save(dPay13);
		Risposta d14 = aService.save(dPay14);
		Risposta d15 = aService.save(dPay15);
		Risposta d16 = aService.save(dPay16);

		// 5D
		DomandaPayload QuestionD5 = new DomandaPayload("What is the primary function of a shark's dorsal fin?",
				Level.MEDIO);
		Domanda domD5 = dService.save(QuestionD5);

		RispostaPayload dPay17 = new RispostaPayload("Stability and balance", true, domD5);
		RispostaPayload dPay18 = new RispostaPayload("Steering", false, domD5);
		RispostaPayload dPay19 = new RispostaPayload("Propulsion", false, domD5);
		RispostaPayload dPay20 = new RispostaPayload("Capturing prey", false, domD5);

		Risposta d17 = aService.save(dPay17);
		Risposta d18 = aService.save(dPay18);
		Risposta d19 = aService.save(dPay19);
		Risposta d20 = aService.save(dPay20);

		// SeiD
		DomandaPayload QuestionD6 = new DomandaPayload("What is the primary function of a shark's dorsal fin?",
				Level.MEDIO);
		Domanda domD6 = dService.save(QuestionD6);

		RispostaPayload dPay21 = new RispostaPayload("Stability and balance", true, domD6);
		RispostaPayload dPay22 = new RispostaPayload("Steering", false, domD6);
		RispostaPayload dPay23 = new RispostaPayload("Propulsion", false, domD6);
		RispostaPayload dPay24 = new RispostaPayload("Capturing prey", false, domD6);

		Risposta d21 = aService.save(dPay21);
		Risposta d22 = aService.save(dPay22);
		Risposta d23 = aService.save(dPay23);
		Risposta d24 = aService.save(dPay24);

		// SetteD
		DomandaPayload QuestionD7 = new DomandaPayload("What is the primary function of a shark's dorsal fin?",
				Level.MEDIO);
		Domanda domD7 = dService.save(QuestionD7);

		RispostaPayload dPay25 = new RispostaPayload("Stability and balance", true, domD7);
		RispostaPayload dPay26 = new RispostaPayload("Steering", false, domD7);
		RispostaPayload dPay27 = new RispostaPayload("Propulsion", false, domD7);
		RispostaPayload dPay28 = new RispostaPayload("Capturing prey", false, domD7);

		Risposta d25 = aService.save(dPay25);
		Risposta d26 = aService.save(dPay26);
		Risposta d27 = aService.save(dPay27);
		Risposta d28 = aService.save(dPay28);

		// OttoM
		DomandaPayload QuestionD8 = new DomandaPayload("What is the primary function of a shark's dorsal fin?",
				Level.MEDIO);
		Domanda domD8 = dService.save(QuestionD8);

		RispostaPayload dPay29 = new RispostaPayload("Stability and balance", true, domD8);
		RispostaPayload dPay30 = new RispostaPayload("Steering", false, domD8);
		RispostaPayload dPay31 = new RispostaPayload("Propulsion", false, domD8);
		RispostaPayload dPay32 = new RispostaPayload("Capturing prey", false, domD8);

		Risposta d29 = aService.save(dPay29);
		Risposta d30 = aService.save(dPay30);
		Risposta d31 = aService.save(dPay31);
		Risposta d32 = aService.save(dPay32);

		// NoveM
		DomandaPayload QuestionD9 = new DomandaPayload("What is the primary function of a shark's dorsal fin?",
				Level.MEDIO);
		Domanda domD9 = dService.save(QuestionD9);

		RispostaPayload dPay33 = new RispostaPayload("Stability and balance", true, domD9);
		RispostaPayload dPay34 = new RispostaPayload("Steering", false, domD9);
		RispostaPayload dPay35 = new RispostaPayload("Propulsion", false, domD9);
		RispostaPayload dPay36 = new RispostaPayload("Capturing prey", false, domD9);

		Risposta d33 = aService.save(dPay33);
		Risposta d34 = aService.save(dPay34);
		Risposta d35 = aService.save(dPay35);
		Risposta d36 = aService.save(dPay36);

		// DieciM
		DomandaPayload QuestionD10 = new DomandaPayload("What is the primary function of a shark's dorsal fin?",
				Level.MEDIO);
		Domanda domD10 = dService.save(QuestionD10);

		RispostaPayload dPay37 = new RispostaPayload("Stability and balance", true, domD10);
		RispostaPayload dPay38 = new RispostaPayload("Steering", false, domD10);
		RispostaPayload dPay39 = new RispostaPayload("Propulsion", false, domD10);
		RispostaPayload dPay40 = new RispostaPayload("Capturing prey", false, domD10);

		Risposta d37 = aService.save(dPay37);
		Risposta d38 = aService.save(dPay38);
		Risposta d39 = aService.save(dPay39);
		Risposta d40 = aService.save(dPay40);

		// UndiciM
		DomandaPayload QuestionD11 = new DomandaPayload("What is the primary function of a shark's dorsal fin?",
				Level.MEDIO);
		Domanda domD11 = dService.save(QuestionD11);

		RispostaPayload dPay41 = new RispostaPayload("Stability and balance", true, domD11);
		RispostaPayload dPay42 = new RispostaPayload("Steering", false, domD11);
		RispostaPayload dPay43 = new RispostaPayload("Propulsion", false, domD11);
		RispostaPayload dPay44 = new RispostaPayload("Capturing prey", false, domD11);

		Risposta d41 = aService.save(dPay41);
		Risposta d42 = aService.save(dPay42);
		Risposta d43 = aService.save(dPay43);
		Risposta d44 = aService.save(dPay44);

	}

}
