import { Component, OnInit } from '@angular/core';

import { AuthInt } from '../auth/auth-int..interface';
import { AuthService } from '../auth/auth-int/auth.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Utente } from 'src/app/models/utente.interface'; //proviamo ad importare l'interfaccia utente normale.
import { UtentiService } from 'src/app/services/utenti.service'; //proviamo ad importare il service utente normale.
import { NgClass } from '@angular/common';

@Component({
  selector: 'app-dettagliutente',
  templateUrl: './dettagliutente.component.html',
  styleUrls: ['./dettagliutente.component.scss'],
})
export class DettagliutenteComponent implements OnInit {
  utenti: Utente[] =
    []; /* utenti sarà un array di tipo utente che all'inizio sarà vuoto. Questo metodo di scrittura si usa quando vogliamo che l'array esista a prescindere.
  Se invece pensiamo che questo array possa anche rimanere vuoto allora conviene usare undefined.
  Ricordarsi che esiste a prescindere, quindi se voglio fare lo spinner devo mettere undefined.
  (Anche il punto esclamativo funziona. Ma con questo modo se per caso i dati non arrivano va in errore quindi in questo caso è pericoloso)*/
  user!: Utente;
  id!: string;
  file: string = ""; //creo un stringa per ricevere il file dell'immagine
  constructor(
    private route: ActivatedRoute,
    private utentiSrv: UtentiService
  ) {} //nel constructor gli dobbiamo dire cosa useremo

  ngOnInit(): void {
    this.route.params.subscribe((parametro) => {
      this.id = parametro['id'];
      this.caricaDettagli();
    });
  }
  /*Gli diciamo che quando si carica deve recuperare gli utenti. Un metodo httpclient è un observable, quindi chi lo usa lo deve sottoscrivere. Riceverà un arrai di tipo utenti. ((In questo caso non mi serve perchè voglio solo il dettaglio dell'utente). Ma scrivo comunque per vedere se becco l'errore. Scrivo poi nell'html il ciclo for per stampare la lista degli utenti. L'ng for va fatto sull'elemento che si deve ripetere.)
   */

  caricaDettagli() {
    this.utentiSrv.dettaglioUtente(this.id).subscribe((dettaglio) => {
      this.user = dettaglio;
    });
  }

  async onFileChange1(value: string) {
    let fotoAvatar: File | null = null; // Initialize it as null

    if (value === "uno") {
      fotoAvatar = await this.createFileFromPath("../../../assets/img/kisspng-common-bottlenose-dolphin-shark-dinosaur-planet-im-civil-rights-timeline-timetoast-timelines-5bada7392da3d7.794675181538107193187.png");
      console.log("Scelta", value);
    } else if (value === "due") {
      fotoAvatar = await this.createFileFromPath("../../../assets/img/kisspng-shark-5d3b4a0ae0f378.6868345015641666669214.png");
      console.log("Scelta", value);
    } else if (value === "tre") {
      fotoAvatar = await this.createFileFromPath("../../../assets/img/kisspng-tiger-shark-transparency-clip-art-cuteness-linda-cola-de-tiburn-cola-plana-descargar-png-5cff48f9c38b52.160053931560234233801.png");
      console.log("Scelta", value);
    } else if (value === "quattro") {
      fotoAvatar = await this.createFileFromPath("../../../assets/img/transparent-shark-5e8fd1571fd850.8525057415864835431304.png");
      console.log("Scelta", value);
    }

    // Call caricaFoto with the File object
    if (fotoAvatar) {
      this.caricaFoto(fotoAvatar);
    }
  }

  // Helper function to create a File object from a file path
  async createFileFromPath(filePath: string): Promise<File | null> {
    try {
      const response = await fetch(filePath);
      const blob = await response.blob();
      const fileName = filePath.split('/').pop() || 'unknown.png';
      return new File([blob], fileName, { type: blob.type });
    } catch (error) {
      console.error('Error creating File object from path', error);
      return null;
    }
  }

  caricaFoto(file: File) {
    if (file) {
      const formData = new FormData();
      formData.append('file', file);

      this.utentiSrv.uploadUserPhoto(this.id, formData).subscribe(
        (response: any) => {
          if (response && response.imageUrl) {
            console.log('File uploaded successfully');
          } else {
            console.error('Invalid response format from server');
          }
        },
        (error) => {
          console.error('Error uploading file', error);
        }
      );
    }
  }
 /*creo una funzione onFileChange che riceve un evento come parametro, il file selezionato dell'utente è disponibile in event.target.files.
 Abbiamo bisogno farlo diventare disponibile per usarlo come proprietà di background. Quindi lo settiamo come url.*/

}
