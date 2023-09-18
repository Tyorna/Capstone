import { Utente } from "./utente.interface";

export interface Risultati {
   id: string;
   correctAnswers: number;
   score: number;
   level: string;
   user: Utente;
}
