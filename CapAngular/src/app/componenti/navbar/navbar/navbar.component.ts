import { Component, OnInit } from '@angular/core';
import { AuthInt } from '../../auth/auth-int..interface';
import { AuthService } from '../../auth/auth-int/auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {
  user!: AuthInt | null;

  constructor(private authSrv: AuthService) {}

  ngOnInit(): void {
    this.authSrv.user$.subscribe((_user) => {
      this.user = _user;
  });
  }

    logout() {
      this.authSrv.logout();
  }
}
