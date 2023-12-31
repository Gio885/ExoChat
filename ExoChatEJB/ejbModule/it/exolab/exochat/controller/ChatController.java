package it.exolab.exochat.controller;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import it.exolab.exochat.costanti.Costanti;
import it.exolab.exochat.crud.ChatCrud;
import it.exolab.exochat.ejbinterface.ChatControllerInterface;
import it.exolab.exochat.entitymanagerprovider.EntityManagerProvider;
import it.exolab.exochat.model.Chat;

/**
 * Session Bean implementation class ChatController
 */
@Stateless(name = "ChatControllerInterface")
@LocalBean
public class ChatController extends EntityManagerProvider implements ChatControllerInterface {

    public ChatController() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Chat insertChat(Chat chat) throws Exception {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		try {
			ChatCrud chatCrud = new ChatCrud();
			entityManager.getTransaction().begin();
			Chat chatInserita = chatCrud.insertChat(chat, entityManager);
			entityManager.getTransaction().commit();
			return chatInserita;
		}catch(Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			System.out.println("Errore metodo insertChat ---ChatController---");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}finally {
			entityManager.clear();
			entityManager.close();
		}	
	}

	
	
	/*
	@Override
	public void deleteChat(Chat chat) throws Exception {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		try {
			ChatCrud chatCrud = new ChatCrud();
			entityManager.getTransaction().begin();
			chatCrud.deleteChat(chat, entityManager);
			entityManager.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			System.out.println("Errore metodo deleteChat ---ChatController---");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}finally {
			entityManager.clear();
			entityManager.close();
		}			
	}

	@Override
	public List<Chat> findAllChatByUtenteId(Integer utenteId) throws Exception {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		try {
			ChatCrud chatCrud = new ChatCrud();
			List<Chat> listaChatUtente = chatCrud.findChatByUtenteId(utenteId, entityManager);
			if(!listaChatUtente.isEmpty()) {
				return listaChatUtente;
			}else {
				throw new BusinessException("Nessuna chat presente");
			}
		}catch(BusinessException e) {
			e.printStackTrace();
			System.out.println("Nessuna chat presente");
			throw new BusinessException(e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore metodo findAllChatByUtenteId ---ChatController---");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CARICAMENTO_CHAT);
		}finally {
			entityManager.clear();
			entityManager.close();
		}
	}
	
	
	*/
}
