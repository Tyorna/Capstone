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
      this.totalQuestions = +params['totalQuestions'];
      this.correctAnswers = +params['correctAnswers'];
      this.score = Math.round((this.correctAnswers / this.totalQuestions) * 100 * 100) / 100;

    });
  }
}
