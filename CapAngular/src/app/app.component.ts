import { Component } from '@angular/core';
import { AuthService } from './componenti/auth/auth-int/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'CapAngular';

  constructor(private authSrv: AuthService) {}

  ngOnInit(): void {
      this.authSrv.restore();
  }
}
