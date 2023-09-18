import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { Risultati } from '../models/risultati.interface';
import { Utente } from '../models/utente.interface';

@Injectable({
  providedIn: 'root'
})
export class RisultatiService {

  baseURL = environment.baseURL;

  constructor(private http: HttpClient) { }

  aggiungiRisultato(userId: string, correctAnswers: number, level: string, score: number): Observable<any> {
    const dati = {
      userId: userId,
      correctAnswers: correctAnswers,
      level: level,
      score: score
    };
    return this.http.post<Risultati>(`${this.baseURL}risultati`, dati);
  }
}
