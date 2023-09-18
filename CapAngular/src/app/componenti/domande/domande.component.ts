import { Component, OnInit } from '@angular/core';
import { Domande } from 'src/app/models/domande';
import { TestService } from 'src/app/services/test.service';
import { RisultatiService } from 'src/app/services/risultati.service';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { AuthService } from '../auth/auth-int/auth.service';


@Component({
  selector: 'app-domande',
  templateUrl: './domande.component.html',
  styleUrls: ['./domande.component.scss']
})
export class DomandeComponent implements OnInit {

  selectedLevel!: string;
  questions: Domande[] = [];
  currentQuestionIndex: number = 0;
  selectedAnswerIndex: number = -1;
  correctScore: number = 0;
  score: number = 0;
  baseURL = environment.baseURL;

  constructor(
    private route: ActivatedRoute,
    private testService: TestService,
    private risultatiService: RisultatiService,
    private router: Router,
    private http: HttpClient,
    private authService: AuthService
  ) {}

  ngOnInit() {
    this.route.params.subscribe((params) => {
      this.selectedLevel = params['level'];
      this.loadQuestions();
    });
  }

  loadQuestions() {
    this.testService.getDomandeByLivello(this.selectedLevel).subscribe((data) => {
      this.questions = data;
      console.log('Loaded questions:', this.questions);
    });
  }

  selectedQuestion(selectedIndex: number) {
    const currentQuestion = this.questions[this.currentQuestionIndex];
    const selectedAnswer = currentQuestion.answers[selectedIndex];
    console.log('Selected Answer:', selectedAnswer);
    console.log('Is Correct?', selectedAnswer.isCorrect);

    if (selectedAnswer.isCorrect == 1) {
      console.log("The answer is correct");
      this.correctScore++;
    } else {
      console.log("The answer is incorrect");
    }
    this.nextQuestion();
  }

  nextQuestion() {
    if ( this.questions.length === 0) {
      console.log('No questions loaded.');
      return;
    }

    if (this.currentQuestionIndex < this.questions.length - 1) {
      this.currentQuestionIndex++;
      this.selectedAnswerIndex = -1;
      console.log('Index', this.currentQuestionIndex)
      console.log('Index', this.questions.length)
    } else {
      console.log('Reached the end of questions.');
      const totalQuestions = this.questions.length;
    const correctAnswers = this.correctScore;
    const selectedLevel = this.selectedLevel;
    const user = this.authService.recuperaUtenteAttuale();
    if (user) {
      const score = (correctAnswers / totalQuestions) * 100;
console.log('Utente trovato', user.id, user.email);

const  nuovoId = user.id.replace(/"/g, '');

this.risultatiService.aggiungiRisultato(nuovoId, correctAnswers, selectedLevel, score).subscribe(
  (response) => {
    console.log('nuovoId:', nuovoId);
console.log('correctAnswers:', correctAnswers);
console.log('selectedLevel:', selectedLevel);
console.log('score:', score);
    console.log('Result saved successfully', response);
  },
  (error) => {
    console.log('nuovoId:', nuovoId);
console.log('correctAnswers:', correctAnswers);
console.log('selectedLevel:', selectedLevel);
console.log('score:', score);
    console.error('Error saving result', error);
  }
);
    } else {
      console.log('User is not logged in. Cannot save result.');
    }

    this.router.navigate(['risultati'], {
      queryParams: {
        totalQuestions,
        correctAnswers
      }}
    );
  }
}

  calculateCorrectAnswers(): number {
    let correctCount = 0;

    for (const question of this.questions) {
      for (const answer of question.answers) {
        if (answer.isCorrect) {
          correctCount++;
        }
      }
    }

    return correctCount;
  }
}

