import { Risultati } from "./risultati.interface";

export interface Utente {
  id: string;
  email: string;
  username: string;
  risultati: Risultati[];
  fotoAvatar: string;
}
