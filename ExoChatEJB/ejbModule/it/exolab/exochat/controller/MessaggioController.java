package it.exolab.exochat.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import it.exolab.exochat.convertitore.Convertitore;
import it.exolab.exochat.costanti.Costanti;
import it.exolab.exochat.crud.MessaggioCrud;
import it.exolab.exochat.dto.Dto;
import it.exolab.exochat.dto.MessaggioDto;
import it.exolab.exochat.eccezioni.BusinessException;
import it.exolab.exochat.ejbinterface.MessaggioControllerInterface;
import it.exolab.exochat.entitymanagerprovider.EntityManagerProvider;
import it.exolab.exochat.model.Chat;
import it.exolab.exochat.model.Messaggio;
import it.exolab.exochat.model.Utente;

/**
 * Session Bean implementation class MessaggioController
 */
@Stateless(name = "MessaggioControllerInterface")
@LocalBean
public class MessaggioController extends EntityManagerProvider implements MessaggioControllerInterface {

    public MessaggioController() {
    	
    }

	@Override
	public void insertMessaggio(MessaggioDto messaggio) throws Exception {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			MessaggioCrud messaggioCrud = new MessaggioCrud();
			Messaggio messaggioDaInserire = new Convertitore().convertDtoToMessaggio(messaggio);
			messaggioCrud.insertMessaggio(messaggioDaInserire, entityManager);
			entityManager.getTransaction().commit();			
		}catch(Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			System.out.println("Errore insertMessaggio --ControllerMessaggio--");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_DURANTE_INVIO_MESSAGGIO);
		}finally {
			entityManager.clear();
			entityManager.close();
		}
	}
	
	@Override
	public Dto<List<Messaggio>> findMessaggiForChatId(Chat chat) throws Exception {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		Dto <List<Messaggio>> messaggiDto = new Dto <List<Messaggio>>();
		try {
			MessaggioCrud messaggioCrud = new MessaggioCrud();
			List<Messaggio> listaMessaggiChat = messaggioCrud.findMessaggiForChatId(chat, entityManager);
			if(!listaMessaggiChat.isEmpty()) {	
				List<MessaggioDto> listaMessaggiDto = new Convertitore().convertListaMessaggioToDto(listaMessaggiChat);
				messaggiDto.setData(listaMessaggiDto);
				return messaggiDto;
			}else {
				throw new BusinessException(Costanti.NON_CI_SONO_MESSAGGI);
			}			
		}catch(BusinessException e) {
			System.out.println("Errore findMessaggiForChatId   ----MessaggioController---- NON CI SONO MESSAGGI");
			throw new BusinessException(e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore metodo findMessaggiForChatId  ---MessaggioController----");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CARICAMENTO_MESSAGGI);
		}finally {
			entityManager.clear();
			entityManager.close();
		}
	}
	    
	@Override
	public Dto<List<Messaggio>> findLastMessaggeForChat(Utente utente) throws Exception {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		Dto <List<Messaggio>> messaggiDto = new Dto <List<Messaggio>>();
		try {
			MessaggioCrud messaggioCrud = new MessaggioCrud();
			List<Messaggio> listaUltimiMessaggiPerChat = messaggioCrud.findLastMessaggeForChat(utente, entityManager);
			if(!listaUltimiMessaggiPerChat.isEmpty()) {
				List<MessaggioDto> listaMessaggiDto = new Convertitore().convertListaMessaggioToDto(listaUltimiMessaggiPerChat);
				messaggiDto.setData(listaMessaggiDto);
				return messaggiDto;
			}else {
				throw new BusinessException(Costanti.NON_CI_SONO_CHAT_INIZIATE);
			}		
		}catch(BusinessException e) {
			System.out.println("Errore metodo findLastMessaggeForChat ---MessaggioController--- BusinessException  NON CI SONO CHAT INIZIATE");
			throw new BusinessException(e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore metodo findLastMessaggeForChat ---MessaggioController--- ");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CARICAMENTO_MESSAGGI);
		}finally {
			entityManager.clear();
			entityManager.close();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	private void formattaLista (List<Messaggio> listaMessaggiDaFormattare) throws Exception{
//		try {
//			for(Messaggio singoloMessaggio : listaMessaggiDaFormattare) {
//				singoloMessaggio.setDestinatario(new Convertitore().convertUtenteToDto(singoloMessaggio.getDestinatario()));
//				singoloMessaggio.setMittente(new Convertitore().convertUtenteToDto(singoloMessaggio.getMittente()));
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//			System.out.println("Errore metodo formattaLista MessaggioController ");
//			throw new Exception(Costanti.ERRORE_CONTATTA_ASSISTENZA);
//		}
//	}

	
	
	
	
	
	
	/*
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
*/
	
	
	
	
	
	
       	
}
