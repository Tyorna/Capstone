import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { Domande } from '../models/domande';

@Injectable({
  providedIn: 'root'
})
export class TestService {

  baseURL = environment.baseURL;

  constructor(private http: HttpClient) { }

   //Prendo le domande per livello
  getDomandeByLivello(level: string): Observable<Domande[]> {
    return this.http.get<Domande[]>(`${this.baseURL}domande/by-level/${level}`);
  }

}
