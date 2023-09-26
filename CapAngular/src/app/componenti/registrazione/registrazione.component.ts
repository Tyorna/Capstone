import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth/auth-int/auth.service';//mi serve il service con i metodi
import { Router } from '@angular/router';//faccio spostare l'utente
import { NgForm} from '@angular/forms';//mi serve per far funzionare il form

@Component({
  selector: 'app-registrazione',
  templateUrl: './registrazione.component.html',
  styleUrls: ['./registrazione.component.scss']
})
export class RegistrazioneComponent implements OnInit {

  isLoading = false;

  constructor(private authSrv: AuthService, private router: Router) {}//solito

  ngOnInit(): void {}

  registra(form: NgForm) {
      this.isLoading = true;
      console.log(form.value);
      try {
          this.authSrv.signup(form.value).subscribe();
          this.router.navigate(['auth/login']);
          this.isLoading = false
      } catch (error: any) {
          console.error(error);
          if (error.status == 400) {
              alert('Email già registrata!');
              this.router.navigate(['auth/register']);
          }
          this.isLoading = false
      }
  }
}
