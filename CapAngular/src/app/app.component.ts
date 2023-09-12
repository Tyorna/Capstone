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
      //Called after the constructor, initializing input properties, and the first call to ngOnChanges.
      //Add 'implements OnInit' to the class.
      this.authSrv.restore();
  }
}
