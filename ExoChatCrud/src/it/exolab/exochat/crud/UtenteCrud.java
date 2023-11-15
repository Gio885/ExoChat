package it.exolab.exochat.crud;

import it.exolab.exochat.model.Utente;
import it.exolab.exochat.costanti.*;
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
	public List<Utente> findAllUtenti(EntityManager entityManager) throws Exception {
        try {
            String queryString = "SELECT u FROM Utente u";
            Query query = entityManager.createQuery(queryString);
            return query.getResultList();
        }catch(Exception e) {
			System.out.println("Errore nel metodo findAllUtenti della classe UtenteCrud ---Exception---");
			e.printStackTrace();
			throw new Exception(Costanti.ERRORE_CARICAMENTO_UTENTI);
		}
    }

    public Utente findUtenteById(Integer idUtente, EntityManager entityManager) throws Exception {
        try {
            return entityManager.find(Utente.class, idUtente);
        }catch(Exception e) {
			System.out.println("Errore nel metodo findUtenteById della classe UtenteCrud ---Exception---");
			e.printStackTrace();
			throw new Exception(Costanti.ERRORE_RICERCA_UTENTE);
		}
    }

    public Utente findUtenteByUsername(String username, EntityManager entityManager) throws Exception {
        try {
            String queryString = "SELECT u FROM Utente u WHERE u.username = :username";
            Query query = entityManager.createQuery(queryString);
            query.setParameter("username", username);
            return (Utente) query.getSingleResult();
        }catch(Exception e) {
			System.out.println("Errore nel metodo findUtenteByUsername della classe UtenteCrud ---Exception---");
			e.printStackTrace();
			throw new Exception(Costanti.ERRORE_RICERCA_UTENTE);
		}
    }

    public Utente updateUtente(Utente utente, EntityManager entityManager) throws Exception {
        try {
            return entityManager.merge(utente);
        }catch(Exception e) {
			System.out.println("Errore nel metodo updateUtente della classe UtenteCrud ---Exception---");
			e.printStackTrace();
			throw new Exception(Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}
    }
	
	public Utente insertUtente(Utente utente, EntityManager entityManager) throws Exception {
		
		try {
			entityManager.persist(utente);
			entityManager.flush();   // SI ASSICURA CHE LE MODIFICHE VENGANO APPLICATE PRIMA DI OTTENERE L'ID GENERATO
			return utente;
		}catch(Exception e) {
			System.out.println("Errore nel metodo insertUtente della classe UtenteCrud");
			e.printStackTrace();
			throw new Exception(Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}
	}
	
	  public void deleteUtente(Integer idUtente, EntityManager entityManager) throws Exception {
		  
	        try {
	            Utente utenteDaEliminare = entityManager.find(Utente.class, idUtente);    
	            if (utenteDaEliminare != null) {
	                entityManager.remove(utenteDaEliminare);
	            } else {
	                throw new EntityNotFoundException("Utente non trovato per l'ID specificato: " + idUtente);
	            }      
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new Exception(Costanti.ERRORE_CONTATTA_ASSISTENZA);
	        }
	    }
	  
	  public Utente findUtenteByEmailAndPassword (Utente utente,EntityManager entityManager) throws Exception {
		  try {
			  String queryString = "SELECT u FROM Utente u WHERE u.email = :emailUtente and u.password = :passwordUtente";
			  Query query = entityManager.createQuery(queryString);
			  query.setParameter("emailUtente", utente.getEmail());
			  query.setParameter("passwordUtente", utente.getPassword());
			  return (Utente) query.getSingleResult();
		  }catch(Exception e) {
			  e.printStackTrace();
			  System.out.println("Errore metodo findUtenteByEmailAndPassword ---UtenteCrud---");
			  throw new Exception(Costanti.ERRORE_CONTATTA_ASSISTENZA);
		  }
	  }
	  
}

