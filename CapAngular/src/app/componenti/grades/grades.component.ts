import { Component, OnInit } from '@angular/core';
import { AuthInt } from '../auth/auth-int..interface';
import { AuthService } from '../auth/auth-int/auth.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Utente } from 'src/app/models/utente.interface';
import { UtentiService } from 'src/app/services/utenti.service';
import { NgClass } from '@angular/common';

@Component({
  selector: 'app-grades',
  templateUrl: './grades.component.html',
  styleUrls: ['./grades.component.scss']
})
export class GradesComponent implements OnInit {

  utenti: Utente[] =
  [];
user!: Utente;
id!: string;
selectedId: string | null = null;
constructor(
  private route: ActivatedRoute,
  private utentiSrv: UtentiService
) {}
ngOnInit(): void {
  this.route.params.subscribe((parametro) => {
    this.id = parametro['id'];
    this.caricaDettagli();
  });
}

caricaDettagli() {
  this.utentiSrv.dettaglioUtente(this.id).subscribe((dettaglio) => {
    this.user = dettaglio;
    this.user.risultati.sort((a, b) => {
      const dateA = new Date(a.timestamp);
      const dateB = new Date(b.timestamp);
      return dateB.getTime() - dateA.getTime();
    });
  });
}

cancRisultato(id: string) {
  if (this.selectedId === id) {
    this.selectedId = null;
  } else {
    this.selectedId = id;
  }
  setTimeout(() => {
    this.utentiSrv.cancellaRisultato(id).subscribe(() => {
      this.user.risultati = this.user.risultati.filter(risultato => risultato.id !== id);
    });
  }, 3000);
}
}
