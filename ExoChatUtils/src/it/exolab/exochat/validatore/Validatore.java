package it.exolab.exochat.validatore;

import java.util.ArrayList;
import java.util.List;

import it.exolab.exochat.costanti.Costanti;
import it.exolab.exochat.model.Utente;

public class Validatore {

	public List<String> validatoreUtente(Utente utente){

		List<String> errori = new ArrayList<String>();
		if (null == utente.getUsername() && !(utente.getUsername().matches(Costanti.REGEX_USERNAME))) {
			errori.add("Inserisci un Username valido, l'username deve essere di lunghezza compresa tra 3 e 20 caratteri, puo contenere lettere (minuscolo e maiuscolo), numeri e il carattere speciale underscore");
		}
		if (null == utente.getEmail() && utente.getEmail().length() <= 8 && utente.getEmail().length() >= 30
				&& !(utente.getEmail().matches(Costanti.REGEX_EMAIL))) {
			errori.add("Inserisci un Email valida, puo contentere lettere ( maiuscole e minuscole), numeri, caratteri speciali e deve avere una lunghezza compresa tra 8 e 30 caratteri");
		}
		if (null == utente.getPassword() && utente.getPassword().length() <= 8 && utente.getPassword().length() >= 20
				&& !(utente.getPassword().matches(Costanti.REGEX_PASSWORD))) {
			errori.add("Inserisci una Password valida, deve contenere almeno un carattere maiuscolo, un carattere minuscolo, un carattere speciale e deve avere una lunghezza compresa tra 8 e 20 caratteri");
		}
		return errori;
	}

}
