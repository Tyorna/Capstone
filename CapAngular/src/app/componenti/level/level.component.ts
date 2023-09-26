import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-level',
  templateUrl: './level.component.html',
  styleUrls: ['./level.component.scss']
})
export class LevelComponent implements OnInit {

  selectedLevel: string = 'BASE';

  constructor(private router: Router) { }

  ngOnInit(): void {
  }
  startTest() {
    this.router.navigate(['domande/by-level/', this.selectedLevel]);
  }
}
