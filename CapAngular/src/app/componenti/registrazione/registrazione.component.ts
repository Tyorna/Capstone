import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth/auth-int/auth.service';
import { Router } from '@angular/router';
import { NgForm} from '@angular/forms';

@Component({
  selector: 'app-registrazione',
  templateUrl: './registrazione.component.html',
  styleUrls: ['./registrazione.component.scss']
})
export class RegistrazioneComponent implements OnInit {

  isLoading = false;
  hasError = false;

  constructor(private authSrv: AuthService, private router: Router) {}

  ngOnInit(): void {}

  registra(form: NgForm) {
    this.isLoading = true;
    this.hasError = false;
    console.log(form.value);

    this.authSrv.signup(form.value).subscribe(
      () => {
        this.router.navigate(['auth/login']);
        this.isLoading = false;
      },
      (error) => {
        console.error(error);
        if (error.status === 400) {
          alert('Email già registrata!');
        } else if (error.status === 403){
          alert('Inserire una mail valida!');
        }
        this.isLoading = false;
        this.hasError = true;
      }
    );
  }
}
