package it.exolab.exochat.controller;

import it.exolab.exochat.convertitore.Convertitore;
import it.exolab.exochat.costanti.Costanti;
import it.exolab.exochat.crud.MessaggioCrud;
import it.exolab.exochat.eccezioni.BusinessException;
import it.exolab.exochat.ejbinterface.MessaggioControllerInterface;
import it.exolab.exochat.model.Messaggio;
import it.exolab.exochat.model.*;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 * Session Bean implementation class MessaggioController
 */
@Stateless(name = "MessaggioControllerInterface")
@LocalBean
public class MessaggioController implements MessaggioControllerInterface {

    
	@PersistenceUnit(name = Costanti.PERSISTENCE_UNIT_NAME)
	private EntityManagerFactory entityManagerFactory;
	
    public MessaggioController() {
    	
    }

	@Override
	public List<Messaggio> findMessaggioByUtenteId(Integer utenteId) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			MessaggioCrud messaggioCrud = new MessaggioCrud();
			List<Messaggio> listaMessaggi = messaggioCrud.findMessaggioByUtenteId(utenteId, entityManager);
			return listaMessaggi;
//			if(!listaMessaggi.isEmpty()) {
//				Dto <Messaggio> dtoListaMessaggiChat = listaMessaggiRaggruppatiPerChat(listaMessaggi);
//				return dtoListaMessaggiChat;	
//			}else {
//				throw new BusinessException("Non ci sono messaggi");
//			}					
		}catch(BusinessException e) {
			throw new BusinessException(e.getMessage());
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore findMessaggioByUtenteId --ControllerMessaggio--");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}finally {
			entityManager.close();
		}
	}

	@Override
	public List<Messaggio> findMessaggioByGroupId(Integer gruppoId) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			MessaggioCrud messaggioCrud = new MessaggioCrud();
			List<Messaggio> listaMessaggiGruppo = messaggioCrud.findMessaggioByGroupId(gruppoId, entityManager);
			return listaMessaggiGruppo;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore findMessaggioByGroupId --ControllerMessaggio--");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}finally {
			entityManager.close();
		}
	}

	@Override
	public void insertMessaggio(Messaggio messaggio) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			MessaggioCrud messaggioCrud = new MessaggioCrud();
			messaggioCrud.insertMessaggio(messaggio, entityManager);
			entityManager.getTransaction().commit();			
		}catch(Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			System.out.println("Errore insertMessaggio --ControllerMessaggio--");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}finally {
			entityManager.close();
		}
	}
	
	@Override
	public List<Messaggio> findMessaggiForChatId(Chat chat) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			MessaggioCrud messaggioCrud = new MessaggioCrud();
			List<Messaggio> listaMessaggiChat = messaggioCrud.findMessaggiForChatId(chat, entityManager);
			return listaMessaggiChat;			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore metodo findMessaggiForChatId  ---MessaggioController----");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CARICAMENTO_CHAT);
		}
	}
	    

	@Override
	public List<Messaggio> findLastMessaggeForChat(Utente utente) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			MessaggioCrud messaggioCrud = new MessaggioCrud();
			List<Messaggio> listaUltimiMessaggiPerChat = messaggioCrud.findLastMessaggeForChat(utente, entityManager);
			if(!listaUltimiMessaggiPerChat.isEmpty()) {
				formattaLista(listaUltimiMessaggiPerChat);
				return listaUltimiMessaggiPerChat;
			}else {
				throw new BusinessException("Non ci sono chat");
			}		
		}catch(BusinessException e) {
			e.printStackTrace();
			System.out.println("Errore metodo findLastMessaggeForChat ---MessaggioController--- BusinessException");
			throw new BusinessException(e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore metodo findLastMessaggeForChat ---MessaggioController--- ");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CARICAMENTO_MESSAGGI);
		}
	}
	
	private void formattaLista (List<Messaggio> listaMessaggiDaFormattare) throws Exception{
		try {
			for(Messaggio singoloMessaggio : listaMessaggiDaFormattare) {
				singoloMessaggio.setDestinatario(new Convertitore().convertUtenteToDto(singoloMessaggio.getDestinatario()));
				singoloMessaggio.setMittente(new Convertitore().convertUtenteToDto(singoloMessaggio.getMittente()));
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore metodo formattaLista MessaggioController ");
			throw new Exception(Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}
	}

       	
}
