import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { AuthService } from '../auth/auth-int/auth.service';
import { AuthInt } from '../auth/auth-int..interface';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  isLoading = false;

  constructor(private authSrv: AuthService, private router: Router) {}

  ngOnInit(): void {
  }

  accedi(form: NgForm) {
    this.isLoading = true;
    console.log(form.value);
    try {
        this.authSrv.login(form.value).subscribe();
        setTimeout(() => {
        if(localStorage.getItem("user")){
        this.isLoading = false;
        alert('Login effettuato!');
        this.router.navigate(['/profilo']);
      } else {
      this.isLoading = false;
      alert('Login sbagliato!');
      this.router.navigate(['auth/login']);
      }
    }, 3000);
    } catch (error) {
      alert(error);
  }
  }
}
