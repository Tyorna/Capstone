import { Component, OnInit } from '@angular/core';
import { Domande } from 'src/app/models/domande';
import { TestService } from 'src/app/services/test.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-domande',
  templateUrl: './domande.component.html',
  styleUrls: ['./domande.component.scss']
})
export class DomandeComponent implements OnInit {

  questions: any[] = [];
  currentQuestionIndex: number = 0;
  selectedLevel: string = 'EASY';

  constructor(private route: ActivatedRoute, private testService: TestService) {}

  ngOnInit(): void {
    //Pesco
    this.route.params.subscribe((params) => {
      const level = params['level'];
      this.testService.getDomandeByLivello(level).subscribe((data: any) => {
        this.questions = data;
      });
    });
  }
    }
