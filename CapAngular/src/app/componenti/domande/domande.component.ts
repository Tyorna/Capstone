import { Component, OnInit } from '@angular/core';
import { Domande } from 'src/app/models/domande';
import { TestService } from 'src/app/services/test.service';
import { ActivatedRoute, Router } from '@angular/router';

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

  constructor(
    private route: ActivatedRoute,
    private testService: TestService,
    private router: Router
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

    if (selectedAnswer.isCorrect) {
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

    if (this.currentQuestionIndex <= this.questions.length - 1) {
      this.currentQuestionIndex++;
      this.selectedAnswerIndex = -1;
      console.log('Index', this.currentQuestionIndex)
      console.log('Index', this.questions.length)
    } else {
      console.log('Reached the end of questions.');
      const totalQuestions = this.questions.length;
      const correctAnswers = this.correctScore;
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

