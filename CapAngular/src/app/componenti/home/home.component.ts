import { Component, OnInit } from '@angular/core';
import { AuthInt } from '../auth/auth-int..interface';
import { AuthService } from '../auth/auth-int/auth.service';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  user!: AuthInt | null;

  constructor(private authSrv: AuthService) { }

  ngOnInit(): void {
    this.authSrv.user$.subscribe((_user) => {
      this.user = _user;
  });
  }

}
