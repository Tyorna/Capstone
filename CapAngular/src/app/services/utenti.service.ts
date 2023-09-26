import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Utente } from '../models/utente.interface';
import { Risultati } from '../models/risultati.interface';
@Injectable({
  providedIn: 'root'
})
export class UtentiService {

  baseUrl = environment.baseURL;

  constructor(private http: HttpClient) { }

  recupera() {
    return this.http.get<Utente[]>(`${this.baseUrl}users`);
}

dettaglioUtente(userId: string) {
    return this.http.get<Utente>(`${this.baseUrl}users/${userId}`);
}

cancella(userId: string) {
    return this.http.delete<Utente>(`${this.baseUrl}users/${userId}`);
}

aggiungi(dati: Utente) {
    return this.http.post<Utente>(`${this.baseUrl}users`, dati);
}

cancellaRisultato(id: string) {
  return this.http.delete<Risultati>(`${this.baseUrl}risultati/${id}`);
}

uploadUserPhoto(userId: string, file: FormData) {
  return this.http.put<string>(`${this.baseUrl}users/${userId}/foto`, file);
}
}


