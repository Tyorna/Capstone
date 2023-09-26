import { Risultati } from "./risultati.interface";

export interface Utente {
  id: string;
  email: string;
  username: string;
  risultati: Risultati[];
  fotoAvatar: string;
}

/*L'interfaccia mi serve per impacchettare una base dati, perchè devo fare gli oggetti come sono nel database (db.json). Si usano infatti questi modelli di dati.
Dove ipotizzo che quel dato non c'è sempre metto il punto interrogativo.
*/
