package it.exolab.exochat.controller;

import it.exolab.exochat.costanti.Costanti;
import it.exolab.exochat.crud.ChatCrud;
import it.exolab.exochat.ejbinterface.ChatControllerInterface;
import it.exolab.exochat.model.Chat;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 * Session Bean implementation class ChatController
 */
@Stateless(name = "ChatControllerInterface")
@LocalBean
public class ChatController implements ChatControllerInterface {

    @PersistenceUnit(name = Costanti.PERSISTENCE_UNIT_NAME)
	private EntityManagerFactory entityManagerFactory;
	
	
    public ChatController() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Chat> findAllChatByUtenteId(Integer utenteId) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			ChatCrud chatCrud = new ChatCrud();
			List<Chat> listaChatUtente = chatCrud.findChatByUtenteId(utenteId, entityManager);
			return listaChatUtente;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore metodo findAllChatByUtenteId ---ChatController---");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CARICAMENTO_CHAT);
		}finally {
			entityManager.close();
		}
	}

	@Override
	public Chat insertChat(Chat chat) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
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
			entityManager.close();
		}		
	}

	@Override
	public void deleteChat(Chat chat) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			ChatCrud chatCrud = new ChatCrud();
			entityManager.getTransaction().begin();
			chatCrud.deleteChat(chat.getIdChat(), entityManager);
			entityManager.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			System.out.println("Errore metodo deleteChat ---ChatController---");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}finally {
			entityManager.close();
		}				
	}

}
