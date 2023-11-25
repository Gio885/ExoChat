package it.exolab.exochat.validatore;

import java.util.ArrayList;
import java.util.List;

import it.exolab.exochat.costanti.Costanti;
import it.exolab.exochat.model.Utente;

public class Validatore {

	public List<String> validatoreUtente(Utente utente){

		List<String> errori = new ArrayList<String>();
		if (null == utente.getUsername() && !(utente.getUsername().matches(Costanti.REGEX_USERNAME))) {
			errori.add(Costanti.ERRORE_VALIDAZIONE_USERNAME);
		}
		if (null == utente.getEmail() && utente.getEmail().length() <= 8 && utente.getEmail().length() >= 30
				&& !(utente.getEmail().matches(Costanti.REGEX_EMAIL))) {
			errori.add(Costanti.ERRORE_VALIDAZIONE_EMAIL);
		}
		if (null == utente.getPassword() && utente.getPassword().length() <= 8 && utente.getPassword().length() >= 20
				&& !(utente.getPassword().matches(Costanti.REGEX_PASSWORD))) {
			errori.add(Costanti.ERRORE_VALIDAZIONE_PASSWORD);
		}
		return errori;
	}

}
