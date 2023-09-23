import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';//serve per fare le chiamate http.
import { Utente } from '../models/utente.interface';//importo l'interfaccia.
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

/*metodo recupera. Gli diciamo che il dato che ti arriva sara un array dentro il quale ci saranno degli oggetti che saranno impacchettati così.
Ecco perchè se non cè corrispondenza tra quello che c'è scritto nel js e quello del nostro modello di dati non funziona niente. E poi dichiaro il nostro url. Stiamo interrogando l'endpoint utente.
Chi lo deve usare? Il component. quindi lo deve importare.
*/

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

}


