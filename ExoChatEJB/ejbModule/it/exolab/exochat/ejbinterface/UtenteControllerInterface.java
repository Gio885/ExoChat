package it.exolab.exochat.ejbinterface;

import javax.ejb.Local;

import it.exolab.exochat.model.Utente;

@Local
public interface UtenteControllerInterface {

	Utente findUtente(Utente utente) throws Exception;
	
	
}
