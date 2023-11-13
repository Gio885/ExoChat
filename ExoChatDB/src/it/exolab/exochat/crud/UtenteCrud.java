package it.exolab.exochat.crud;

import it.exolab.exochat.model.Utente;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;
import javax.persistence.TransactionRequiredException;


/*
 * 	IllegalArgumentException: Se l'argomento passato a find è di tipo non valido o è null.

	TransactionRequiredException: Se l'operazione find viene eseguita fuori da una transazione attiva e se la persistenza richiede una transazione.

	EntityNotFoundException: Se l'entità richiesta non esiste nel database.

	PersistenceException: Eccezione generica per problemi di persistenza.
 */


public class UtenteCrud {

	public Utente findUtente(Utente utente, EntityManager entityManager) {
		try {
			Utente utenteDaTrovare = entityManager.find(Utente.class, utente);
			return utenteDaTrovare;
		}catch (IllegalArgumentException e) {
			e.printStackTrace();
			System.out.println("l'argomento passato a find è di tipo non valido o è null.");
			throw new IllegalArgumentException("");
		}catch(TransactionRequiredException e) {
			e.printStackTrace();
			System.out.println("operazione find viene eseguita fuori da una transazione attiva e se la persistenza richiede una transazione.");
			throw new TransactionRequiredException("");
		}catch(EntityNotFoundException e){
			e.printStackTrace();
			System.out.println("L'entita non è stata trovata");
			throw new EntityNotFoundException("");
		}catch(PersistenceException e) {
			e.printStackTrace();
			System.out.println("Eccezione generica per problemi di persistenza");	
			throw new PersistenceException("");
		}
	}
}

