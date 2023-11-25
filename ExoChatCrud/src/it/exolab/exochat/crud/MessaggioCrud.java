package it.exolab.exochat.crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import it.exolab.exochat.costanti.Costanti;
import it.exolab.exochat.model.Chat;
import it.exolab.exochat.model.Messaggio;
import it.exolab.exochat.model.Utente;

public class MessaggioCrud extends BaseCrud <Messaggio> {
	
    private BaseCrud<Messaggio> baseCrud = new BaseCrud<Messaggio>();

	
	public Messaggio insertMessaggio(Messaggio messaggio, EntityManager entityManager) throws Exception {
		try {
			return baseCrud.insert(messaggio, entityManager);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Errore metodo insertMessaggio MessaggioCrud ---Exception---");
			throw new Exception(Costanti.ERRORE_DURANTE_INVIO_MESSAGGIO);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Messaggio> findMessaggiForChatId(Chat chat,EntityManager entityManager) throws Exception{
		try {
			String queryString = "SELECT m FROM Messaggio m WHERE m.chat.idChat = :chatId";
			Query query = entityManager.createQuery(queryString);
			query.setParameter("chatId", chat.getIdChat());
			return query.getResultList();		
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore metodo findMessaggiForChatId ----MessaggioCrud----");
			throw new Exception(Costanti.ERRORE_CARICAMENTO_MESSAGGI);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Messaggio> findLastMessaggeForChat(Utente utente, EntityManager entityManager) throws Exception {
		try {
			String queryString = "SELECT m FROM Messaggio m " +
			        "WHERE (m.chat.idChat, m.dataOra) IN (" +
			        "    SELECT c1.idChat, MAX(m1.dataOra) " +
			        "    FROM Messaggio m1 " +
			        "    JOIN m1.chat c1 " +
			        "    WHERE m1.mittente.idUtente = :utenteId OR m1.destinatario.idUtente = :utenteId " +
			        "    GROUP BY c1.idChat) " +
			        "ORDER BY m.dataOra DESC";
			Query query = entityManager.createQuery(queryString,Messaggio.class);
			query.setParameter("utenteId", utente.getIdUtente());
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Errore metodo findLastMessaggeForChat ---MessaggioCrud--- ");
			throw new Exception(Costanti.ERRORE_CARICAMENTO_MESSAGGI);
		}
	}

	
	
	
	
	
	
	
	/*
	String queryString2 = "SELECT * FROM MESSAGGIO m " +
            "WHERE (m.CHAT_ID, m.DATA_ORA) IN (" +
            "    SELECT c1.ID_CHAT, MAX(m1.DATA_ORA) " +
            "    FROM MESSAGGIO m1 " +
            "    JOIN CHAT c1 ON m1.CHAT_ID = c1.ID_CHAT " +
			" 	 WHERE m1.mittente.idUtente = :utenteId OR m1.destinatario.idUtente = :utenteId " +
            "    GROUP BY c1.ID_CHAT) " +
            "ORDER BY m.DATA_ORA DESC";
		String queryString3 = "SELECT m FROM Messaggio m " +     
           "WHERE (m.chat.idChat, m.dataOra) IN (" +
           "    SELECT c1.idChat, MAX(m1.dataOra) " +
           "    FROM Messaggio m1 " +
           "    JOIN m1.chat c1 " +
            "    GROUP BY c1.idChat) " +
            "ORDER BY m.dataOra DESC";
	

	@SuppressWarnings("unchecked")
	public List<Messaggio> findMessaggioByUtenteId(Integer utenteId, EntityManager entityManager) throws Exception {
		try {
			String queryString = "SELECT m FROM Messaggio m WHERE m.mittente.idUtente = :utenteId OR m.destinatario.idUtente = :utenteId";
			Query query = entityManager.createQuery(queryString);
			query.setParameter("utenteId", utenteId);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Errore findMessaggioByUtenteId --MessaggioCrud--");
			throw new Exception(Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Messaggio> findMessaggioByGroupId(Integer gruppoId, EntityManager entityManager) throws Exception {
		try {
			String queryString = "SELECT m FROM Messaggio m WHERE m.gruppo.idGruppo = :gruppoId";
			Query query = entityManager.createQuery(queryString);
			query.setParameter("gruppoId", gruppoId);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Errore findMessaggioByGroupId --MessaggioCrud--");
			throw new Exception(Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}
	}
	
	public Messaggio updateMessaggio(Messaggio messaggio, EntityManager entityManager) throws Exception {
		try {
			return baseCrud.update(messaggio, entityManager);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Errore nel metodo updateMessaggio UtenteCrud ---Exception---");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}
	}

	public boolean deleteMessaggio(Messaggio messaggio, EntityManager entityManager) throws Exception {
		try {
			return baseCrud.delete(messaggio, entityManager);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Errore nel metodo deleteMessaggio UtenteCrud ---Exception---");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}
	}
	*/
		
}
