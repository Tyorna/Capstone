import { Domande } from "./domande";

export interface Risposta {
  id: string;
  text: string;
  isCorrect: number;
  question: Domande;
}
