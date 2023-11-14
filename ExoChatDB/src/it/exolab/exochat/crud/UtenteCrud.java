package it.exolab.exochat.crud;

import it.exolab.exochat.model.Utente;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;



/*
 * 	IllegalArgumentException: Se l'argomento passato a find è di tipo non valido o è null.

	TransactionRequiredException: Se l'operazione find viene eseguita fuori da una transazione attiva e se la persistenza richiede una transazione.

	EntityNotFoundException: Se l'entità richiesta non esiste nel database.

	PersistenceException: Eccezione generica per problemi di persistenza.
 */


public class UtenteCrud {
	
	@SuppressWarnings("unchecked")
	public List<Utente> findAllUtenti(EntityManager entityManager) {
        try {
            String queryString = "SELECT u FROM Utente u";
            Query query = entityManager.createQuery(queryString);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Errore durante il recupero della lista degli utenti", e);
        }
    }

    public Utente findUtenteById(int idUtente, EntityManager entityManager) {
        try {
            return entityManager.find(Utente.class, idUtente);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Errore durante la ricerca dell'utente per ID", e);
        }
    }

    public Utente findUtenteByUsername(String username, EntityManager entityManager) {
        try {
            String queryString = "SELECT u FROM Utente u WHERE u.username = :username";
            Query query = entityManager.createQuery(queryString);
            query.setParameter("username", username);
            return (Utente) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Errore durante la ricerca dell'utente per username", e);
        }
    }

    public Utente updateUtente(Utente utente, EntityManager entityManager) {
        try {
            return entityManager.merge(utente);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Errore durante l'aggiornamento dell'utente", e);
        }
    }
	
	public void insertUtente(Utente utente, EntityManager entityManager) {
		
		try {
			entityManager.persist(utente);
			
		} catch (Exception e) {
			System.out.println("Errore nel metodo insertUtente della classe UtenteCrud");
			e.printStackTrace();
			throw new RuntimeException("Errore durante l'inserimento dell'utente", e);
		}
	}
	
	  public void deleteUtente(int idUtente, EntityManager entityManager) {
		  
	        try {
	            Utente utenteDaEliminare = entityManager.find(Utente.class, idUtente);
	            
	            if (utenteDaEliminare != null) {
	                entityManager.remove(utenteDaEliminare);
	            } else {
	                throw new EntityNotFoundException("Utente non trovato per l'ID specificato: " + idUtente);
	            }
	      
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new RuntimeException("Errore durante l'operazione di eliminazione dell'utente.", e);
	        }
	    }
}

