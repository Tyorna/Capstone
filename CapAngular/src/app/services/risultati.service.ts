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

  aggiungiRisultato(userID: string, correctAnswers: number, level: string) {
    const dati: Risultati = {
      id: '',
      score: correctAnswers,
      level: level
    };
    return this.http.post<Risultati>(`${this.baseURL}risultati`, dati);
  }
}
