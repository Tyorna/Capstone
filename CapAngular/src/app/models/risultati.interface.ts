import { Utente } from "./utente.interface";

export interface Risultati {
   id: string;
   score: number;
   level: string;
   user: Utente;
}
