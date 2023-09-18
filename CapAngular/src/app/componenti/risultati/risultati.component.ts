import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-risultati',
  templateUrl: './risultati.component.html',
  styleUrls: ['./risultati.component.scss']
})
export class RisultatiComponent implements OnInit {

  totalQuestions!: number;
  correctAnswers!: number;
  score!: number;

  constructor(private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      this.totalQuestions = +params['totalQuestions']; // Convert to number
      this.correctAnswers = +params['correctAnswers']; // Convert to number

      // Calculate the user's score as a percentage
      this.score = (this.correctAnswers / this.totalQuestions) * 100;

    });
  }
}
