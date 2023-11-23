package it.exolab.exochat.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import it.exolab.exochat.convertitore.Convertitore;
import it.exolab.exochat.costanti.Costanti;
import it.exolab.exochat.crud.MessaggioCrud;
import it.exolab.exochat.crud.UtenteCrud;
import it.exolab.exochat.dto.Dto;
import it.exolab.exochat.eccezioni.BusinessException;
import it.exolab.exochat.ejbinterface.UtenteControllerInterface;
import it.exolab.exochat.entitymanagerprovider.EntityManagerProvider;
import it.exolab.exochat.model.Messaggio;
import it.exolab.exochat.model.Utente;
import it.exolab.exochat.validatore.Validatore;


/*
 * 	IllegalArgumentException: Se l'argomento passato a find è di tipo non valido o è null.

	TransactionRequiredException: Se l'operazione find viene eseguita fuori da una transazione attiva e se la persistenza richiede una transazione.

	EntityNotFoundException: Se l'entità richiesta non esiste nel database.

	PersistenceException: Eccezione generica per problemi di persistenza.
 */


/**
 * Session Bean implementation class UtenteController
 * 
 * @PersistenceContext per inettare un istanza entity manager per operazioni di persistenza JTA
 * 
 * @PersistenceUnit per iniettare un istanza della factory per creare entitymanager per fare operazioni di persistenza RESOURCE LOCAL quindi MANUALI
 */
@Stateless(name = "UtenteControllerInterface")
@LocalBean
public class UtenteController extends EntityManagerProvider  implements UtenteControllerInterface {

//	@PersistenceUnit(name = Costanti.PERSISTENCE_UNIT_NAME)
//	private EntityManagerFactory entityManagerFactory;
	
	public UtenteController() {
		
	}

	@Override
	public Dto <Utente> insertUtente(Utente utente) throws Exception {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		try {
			Dto <Utente> dtoUtente = new Dto <Utente>();
			List<String> errori = new Validatore().validatoreUtente(utente);
			if(errori.isEmpty()) {
				UtenteCrud crud = new UtenteCrud();
				buildUtente(utente);			
				entityManager.getTransaction().begin();
				Utente utenteInserito = crud.insertUtente(utente, entityManager);
				entityManager.getTransaction().commit();
				dtoUtente.setData(new Convertitore().convertUtenteToDto(utenteInserito));
				return dtoUtente;
			}else {
				throw new BusinessException(String.join("\n", errori));
			}		
		}catch (BusinessException e) {
			e.printStackTrace();
			System.out.println("Errore validazione Utente insertUtente UtenteController  ---BusinessException--- ");
			throw new BusinessException(e.getMessage()); 
		}catch(Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			System.out.println("Errore nel metodo insertUtente UtenteController ---Exception---");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CONTATTA_ASSISTENZA);
		} finally {
			entityManager.clear();
			entityManager.close();
		}	
	}
	
	@Override
	public Dto<Utente> updateUtente(Utente utente) throws Exception {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		try {
			Dto <Utente> dtoUtente = new Dto <Utente>();
				UtenteCrud crud = new UtenteCrud();
				entityManager.getTransaction().begin();
				Utente utenteInserito = crud.updateUtente(utente, entityManager);
				entityManager.getTransaction().commit();
				dtoUtente.setData(new Convertitore().convertUtenteToDto(utenteInserito));
				return dtoUtente;		
		}catch(Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			System.out.println("Errore nel metodo updateUtente UtenteController ---Exception---");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CONTATTA_ASSISTENZA);
		} finally {
			entityManager.clear();
			entityManager.close();
		}	
	}
	
	
	@Override
	public Dto<Utente> findUtenteByEmailAndPassword(Utente utente) throws Exception{
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		try {		
			Dto <Utente> dtoUtente = new Dto <Utente>();
			UtenteCrud utenteCrud = new UtenteCrud();
			Utente utenteDaTrovare = utenteCrud.findUtenteByEmailAndPassword(utente, entityManager);
			dtoUtente.setData(new Convertitore().convertUtenteToDto(utenteDaTrovare));
			return dtoUtente;							
		}catch(BusinessException e) {
			System.out.println("Errore nel metodo findUtenteByEmailAndPassword BusinessException---UtenteController----");
			throw new BusinessException(e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore nel metodo findUtenteByEmailAndPassword ---UtenteController----");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}finally {
			entityManager.clear();
			entityManager.close();
		}
	}
	
	@Override
	public Dto<List<Utente>> findAllUtentiChatNonIniziate(Utente utente) throws Exception {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		try {
			Dto<List<Utente>> listaUtentiDto = new Dto<List<Utente>>();
			UtenteCrud utenteCrud = new UtenteCrud();
			List<Utente> listaUtenti = utenteCrud.findAllUtentiChatNonIniziate(utente, entityManager);
			if(!listaUtenti.isEmpty()) {
				listaUtentiDto.setData(new Convertitore().convertListaUtenteToDto(listaUtenti));
				return listaUtentiDto;	
			}else {
				throw new BusinessException("Non ci sono contatti");
			}					
		}catch(BusinessException e) {
			e.printStackTrace();
			System.out.println("Errore nel metodo findAllUtentiChatNonIniziate UtenteController ---Exception---");
			throw new Exception(e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore nel metodo findAllUtentiChatNonIniziate UtenteController ---Exception---");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CARICAMENTO_UTENTI);
		} finally {
			entityManager.clear();
			entityManager.close();
		}
	}

	@Override
	public Dto<List<Utente>> findAllUtenti() throws Exception {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		try {
			Dto<List<Utente>> listaUtentiDto = new Dto<List<Utente>>();
			UtenteCrud utenteCrud = new UtenteCrud();
			List<Utente> listaUtenti = utenteCrud.findAllUtenti(entityManager);
			if(!listaUtenti.isEmpty()) {
				listaUtentiDto.setData(new Convertitore().convertListaUtenteToDto(listaUtenti));
				return listaUtentiDto;	
			}else {
				throw new BusinessException("Non ci sono contatti");
			}					
		}catch(BusinessException e) {
			e.printStackTrace();
			System.out.println("Errore nel metodo findAllUtenti UtenteController ---Exception---");
			throw new Exception(e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore nel metodo findAllUtenti UtenteController ---Exception---");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CARICAMENTO_UTENTI);
		} finally {
			entityManager.clear();
			entityManager.close();
		}
	}

	/*
	@Override
	public Dto<Utente> findUtenteById(Integer idUtente) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			Dto <Utente> dtoUtente = new Dto <Utente>();
			UtenteCrud utenteCrud = new UtenteCrud();
			Utente utenteDaTrovare = utenteCrud.findById(idUtente, entityManager);
			dtoUtente.setData(new Convertitore().convertUtenteToDto(utenteDaTrovare));
			return dtoUtente;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore nel metodo findUtenteById UtenteController ---Exception---");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_RICERCA_UTENTE);
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Dto<Utente> findUtenteByUsername(String username) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			Dto <Utente> dtoUtente = new Dto <Utente>();
			if(null == username || username.equalsIgnoreCase(" ")) {
				throw new BusinessException("Inserisci un Username");
			}else {
				UtenteCrud utenteCrud = new UtenteCrud();
				Utente utenteDaTrovare = utenteCrud.findUtenteByUsername(username, entityManager);
				dtoUtente.setData(new Convertitore().convertUtenteToDto(utenteDaTrovare));
				return dtoUtente;		
			}			
		}catch(BusinessException e) {
			e.printStackTrace();
			System.out.println("Errore in findUtenteByUsername --- username vuoto o null "+ username);
			throw new BusinessException(e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore nel metodo findUtenteByUsername ---Exception---");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_RICERCA_UTENTE);
		}finally {
			entityManager.close();
		}
	}

	
	//QUANDO DEVE MODIFICARE LE IMPOSTAZIONI DEL PROFILO GLI FACCIAMO RIMETTERE LA PASSWORD CON L'EMAIL GIA INSERITA RIFACCIAMO UNA LOGIN E
	//RESTITUIAMO L'UTENTE COMPLETO COSI POSSIAMO FARCI L'UPDATE CON IL VALIDATORE E CAMBIARE USERNAME EMAIL PASSWORD 
	@Override
	public Dto<Utente> updateUtente(Utente utente) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			Dto <Utente> dtoUtente = new Dto <Utente>();
			new Validatore().validatoreUtente(utente);
			UtenteCrud utenteCrud = new UtenteCrud();
			entityManager.getTransaction().begin();
			Utente utenteAggiornato = utenteCrud.update(utente, entityManager);
			entityManager.getTransaction().commit();
			dtoUtente.setData(new Convertitore().convertUtenteToDto(utenteAggiornato));
			return dtoUtente;		
		}catch(BusinessException e) {
			e.printStackTrace();
			System.out.println("Errore validazione Utente updateUtente ---BusinessException---");
			throw new BusinessException(e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			System.out.println("Errore nel metodo updateUtente ---Exception---");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}finally {
			entityManager.close();
		}
	}

	@Override
	public void deleteUtente(Utente utente) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			UtenteCrud utenteCrud = new UtenteCrud();
			entityManager.getTransaction().begin();
			utenteCrud.delete(utente, entityManager);
			entityManager.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			System.out.println("Errore nel metodo deleteUtente ---Exception---");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}finally {
			entityManager.close();
		}
	}
	*/

	
	private void buildUtente(Utente utente) throws IOException {
		try {
			utente.setInfo("Disponibile");
			String imagePath = "fotoprofilo.png";			
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			InputStream inputStream = classLoader.getResourceAsStream(imagePath);
			if (inputStream != null) {
			    // Leggi l'immagine dall'input stream e convertila in un array di byte
			    byte[] imageBytes = inputStream.readAllBytes();

			    // Imposta l'array di byte nella proprietà 'foto' dell'utente
			    utente.setFoto(imageBytes);		    
			    inputStream.close();
			}
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Errore metodo setFotoUtente  ----UtenteController----");
            throw new IOException(Costanti.ERRORE_CONTATTA_ASSISTENZA);
        }
	}

	

	


}
