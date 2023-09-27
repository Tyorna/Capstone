import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, throwError } from 'rxjs';
import { JwtHelperService } from '@auth0/angular-jwt';
import { tap, catchError } from 'rxjs/operators';
import { AuthInt } from '../auth-int..interface';
import { environment } from 'src/environments/environment';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  jwtHelper = new JwtHelperService();
  baseURL = environment.baseURL;
  private authSubj = new BehaviorSubject<null | AuthInt>(null);
  user!: AuthInt;

  user$ = this.authSubj.asObservable();
  timeoutLogout: any;

  constructor(private http: HttpClient, private router: Router) { }

  login(data: { email: string; password: string }) {
    return this.http.post<AuthInt>(`${this.baseURL}auth/login`, data).pipe(
        tap((data) => {
            this.authSubj.next(data);
            this.user = data;
            console.log(this.user);
            localStorage.setItem('user', JSON.stringify(data));
            this.autoLogout(data);
        }),
        catchError(this.errors)
    );
}

restore(): boolean {
    const user = localStorage.getItem('user');
    if (!user) {
        return false;
    }
    const userData: AuthInt = JSON.parse(user);
    if (this.jwtHelper.isTokenExpired(userData.accessToken)) {
        return false;
    }
    this.authSubj.next(userData);
    this.autoLogout(userData);
    return true
}

signup(data: {
    username: string;
    email: string;
    password: string;
}) {
    return this.http.post(`${this.baseURL}auth/register`, data);
}

logout() {
    this.authSubj.next(null);
    localStorage.removeItem('user');
    this.router.navigate(['/']);
    if (this.timeoutLogout) {
        clearTimeout(this.timeoutLogout);
    }
}

autoLogout(data: AuthInt) {
    const expirationDate = this.jwtHelper.getTokenExpirationDate(
        data.accessToken
    ) as Date;
    const expirationMilliseconds =
        expirationDate.getTime() - new Date().getTime();
    this.timeoutLogout = setTimeout(() => {
        this.logout();
    }, expirationMilliseconds);
}

recuperaUtente(id: number) {
  return this.http.get<AuthInt>(`${this.baseURL}users/${id}`);
}

recuperaUtenteAttuale(): AuthInt | null {
  return this.authSubj.value;
}

recuperaId(): string {
  const user = this.authSubj.value;

  if (user && user.id) {
    return user.id;
  } else {
    return '';
  }
}

private errors(err: any) {
    switch (err.error) {
        case 'Email already exists':
            return throwError('Utente già presente');
            break;

        case 'Email format is invalid':
            return throwError('Formato mail non valido');
            break;

        default:
            return throwError('Errore nella chiamata');
            break;
    }
}
}
