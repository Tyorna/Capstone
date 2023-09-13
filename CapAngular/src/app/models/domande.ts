import { Risposta } from "./risposta";

export interface Domande {
  id: string;
  text: string;
  level: string;
  answers: Risposta[]
}
