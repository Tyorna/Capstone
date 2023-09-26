import { Component, OnInit } from '@angular/core';

import { AuthInt } from '../auth/auth-int..interface';
import { AuthService } from '../auth/auth-int/auth.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Utente } from 'src/app/models/utente.interface';
import { UtentiService } from 'src/app/services/utenti.service';
import { NgClass } from '@angular/common';

@Component({
  selector: 'app-dettagliutente',
  templateUrl: './dettagliutente.component.html',
  styleUrls: ['./dettagliutente.component.scss'],
})
export class DettagliutenteComponent implements OnInit {
  utenti: Utente[] = [];
  user!: Utente;
  id!: string;
  selectedFile: File | null = null;
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
    });
  }

  convertFormat() {
    let imageInitialUrl = 'data:image/png;base64,';
    console.log('Immagine');
    return imageInitialUrl;
  }

  async salvaImg(value: string) {
    let fotoAvatar: File | null = null;

    if (value === 'uno') {
      fotoAvatar = await this.createFileFromPath(
        '../../../assets/img/kisspng-common-bottlenose-dolphin-shark-dinosaur-planet-im-civil-rights-timeline-timetoast-timelines-5bada7392da3d7.794675181538107193187.png'
      );
      console.log('Scelta', value);
    } else if (value === 'due') {
      fotoAvatar = await this.createFileFromPath(
        '../../../assets/img/kisspng-shark-5d3b4a0ae0f378.6868345015641666669214.png'
      );
      console.log('Scelta', value);
    } else if (value === 'tre') {
      fotoAvatar = await this.createFileFromPath(
        '../../../assets/img/kisspng-tiger-shark-transparency-clip-art-cuteness-linda-cola-de-tiburn-cola-plana-descargar-png-5cff48f9c38b52.160053931560234233801.png'
      );
      console.log('Scelta', value);
    } else if (value === 'quattro') {
      fotoAvatar = await this.createFileFromPath(
        '../../../assets/img/transparent-shark-5e8fd1571fd850.8525057415864835431304.png'
      );
      console.log('Scelta', value);
    }

    if (fotoAvatar) {
      const formData = new FormData();
      formData.append('file', fotoAvatar);

      this.caricaFoto(formData);
    }
  }

  caricaFoto(formData: FormData) {
    if (formData) {
      this.utentiSrv.uploadUserPhoto(this.id, formData).subscribe(
        (response: any) => {
          console.log('File uploaded successfully');
          this.caricaDettagli();
        },
        (error) => {
          console.error('Error uploading file', error);
        }
      );
    }
  }

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
}
