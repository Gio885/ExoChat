package it.exolab.exochat.crud;

import it.exolab.exochat.model.*;
import it.exolab.exochat.costanti.*;
import it.exolab.exochat.eccezioni.BusinessException;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/*
 * 	IllegalArgumentException: Se l'argomento passato a find è di tipo non valido o è null.

	TransactionRequiredException: Se l'operazione find viene eseguita fuori da una transazione attiva e se la persistenza richiede una transazione.

	EntityNotFoundException: Se l'entità richiesta non esiste nel database.

	PersistenceException: Eccezione generica per problemi di persistenza.
 */

public class UtenteCrud extends BaseCrud <Utente> {

	/*
	 * entitymanager.flush alineare il container con il DB e clear pulisce
	 * entitymanager, clear utilizzato molto per il remove, bisogna essere sicuri
	 * che l'entita venga dissasociata dal container entityManager.flush fa una
	 * commit cosa che il persist non fa NEL REMOVE FLUSH AND CLEAR Contains --->
	 * RITORNA UN BOOLEAN, PER VERIFICARE SE L'ENTITA E ASSOCIATA AL CONTAINER LE
	 * OPERAZIONI SONO TUTTE A LIVELLO CONTAINTER NON A LIVELLO DB
	 */

    private BaseCrud<Utente> baseCrud = new BaseCrud<Utente>();
    
	
    public Utente insertUtente(Utente utente, EntityManager entityManager) throws Exception {
		try {
			return baseCrud.insert(utente, entityManager);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Errore nel metodo insertUtente della classe UtenteCrud");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}
	}
    
	public Utente updateUtente(Utente utente, EntityManager entityManager) throws Exception {
		try {
			return baseCrud.update(utente, entityManager);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Errore nel metodo updateUtente della classe UtenteCrud ---Exception---");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}
	}

	public boolean deleteUtente(Utente utenteDaEliminare, EntityManager entityManager) throws Exception {
		try {
			return baseCrud.delete(utenteDaEliminare, entityManager);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Errore nel metodo updateUtente della classe UtenteCrud ---Exception---");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Utente> findAllUtenti(EntityManager entityManager) throws Exception {
		try {
			String queryString = "SELECT u FROM Utente u ";
			Query query = entityManager.createQuery(queryString);
			return query.getResultList();
		} catch (Exception e) {
			System.out.println("Errore nel metodo findAllUtenti della classe UtenteCrud ---Exception---");
			e.printStackTrace();
			throw new Exception(Costanti.ERRORE_CARICAMENTO_UTENTI);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Utente> findAllUtentiChatNonIniziate(Utente utente,EntityManager entityManager) throws Exception {
		try {
			String queryString = "SELECT u "
			        + "FROM Utente u "
			        + "WHERE u.idUtente NOT IN "
			        + "(SELECT DISTINCT CASE WHEN m.destinatario.idUtente = :idUtente THEN m.mittente.idUtente ELSE m.destinatario.idUtente END "
			        + " FROM Messaggio m "
			        + " WHERE m.destinatario.idUtente = :idUtente OR m.mittente.idUtente = :idUtente)";
			Query query = entityManager.createQuery(queryString,Utente.class);
			query.setParameter("idUtente", utente.getIdUtente());
			return query.getResultList();
		} catch (Exception e) {
			System.out.println("Errore nel metodo findAllUtentiChatNonIniziate della classe UtenteCrud ---Exception---");
			e.printStackTrace();
			throw new Exception(Costanti.ERRORE_CARICAMENTO_UTENTI);
		}
	}

	public Utente findUtenteByEmailAndPassword(Utente utente, EntityManager entityManager) throws Exception {
		try {
			String queryString = "SELECT u FROM Utente u WHERE u.email = :emailUtente and u.password = :passwordUtente";
			Query query = entityManager.createQuery(queryString, Utente.class);
			query.setParameter("emailUtente", utente.getEmail());
			query.setParameter("passwordUtente", utente.getPassword());
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.println("ClassLoader: " + Utente.class.getClassLoader());
			System.out.println("-----------------------------------------------------------------------------------------------");
			return (Utente) query.getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
			System.out.println("Errore metodo findUtenteByEmailAndPassword ----UtenteCrud---- Nessun entita trovata");
			throw new BusinessException("Credenziali errate");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Errore metodo findUtenteByEmailAndPassword ---UtenteCrud---");
			throw new Exception(Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}
	}






	/*
	 * 
	 * 
	 * 
	 * public Utente findUtenteByUsername(String username, EntityManager
	 * entityManager) throws Exception { try { String queryString =
	 * "SELECT u FROM Utente u WHERE u.username = :username"; Query query =
	 * entityManager.createQuery(queryString,Utente.class);
	 * query.setParameter("username", username); return (Utente)
	 * query.getSingleResult(); }catch(Exception e) { System.out.
	 * println("Errore nel metodo findUtenteByUsername della classe UtenteCrud ---Exception---"
	 * ); e.printStackTrace(); throw new Exception(Costanti.ERRORE_RICERCA_UTENTE);
	 * } }
	 * 
	 * @Override public Utente findById(Integer idUtente, EntityManager
	 * entityManager) throws Exception { try { return
	 * entityManager.find(Utente.class, idUtente); }catch(Exception e) { System.out.
	 * println("Errore nel metodo findUtenteById della classe UtenteCrud ---Exception---"
	 * ); e.printStackTrace(); throw new Exception(Costanti.ERRORE_RICERCA_UTENTE);
	 * } }
	 */

}
