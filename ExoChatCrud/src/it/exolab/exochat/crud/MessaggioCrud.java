package it.exolab.exochat.crud;

import it.exolab.exochat.costanti.Costanti;
import it.exolab.exochat.model.Chat;
import it.exolab.exochat.model.Messaggio;
import it.exolab.exochat.model.Utente;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class MessaggioCrud {

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

	public void insertMessaggio(Messaggio messaggio, EntityManager entityManager) throws Exception {
		try {
			entityManager.persist(messaggio);
			entityManager.flush();
			entityManager.clear();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Errore insertMessaggio --MessaggioCrud--");
			throw new Exception(Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}
	}

	public List<Messaggio> findMessaggiForChatId(Chat chat,EntityManager entityManager) throws Exception{
		try {
			String queryString = "SELECT m FROM Messaggio m WHERE m.chat.idChat = :chatId";
			Query query = entityManager.createQuery(queryString);
			query.setParameter("chatId", chat.getIdChat());
			return query.getResultList();		
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore metodo findMessaggiForChatId ----MessaggioCrud----");
			throw new Exception(Costanti.ERRORE_CARICAMENTO_CHAT);
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Messaggio> findLastMessaggeForChat(Utente utente, EntityManager entityManager) throws Exception {
		try {
			String queryString = "SELECT m " +
					"FROM Messaggio m " +
					"WHERE (m.chat.idChat, m.dataOra) IN (" +
					"  SELECT c1.idChat, MAX(m1.dataOra) " +
					"  FROM Messaggio m1 " +
					"  JOIN m1.chat c1 " +
					"  WHERE m1.mittente.idUtente = :utenteId OR m1.destinatario.idUtente = :utenteId " +
					"  GROUP BY c1.idChat)";
			Query query = entityManager.createQuery(queryString);
			query.setParameter("utenteId", utente.getIdUtente());
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Errore metodo findLastMessaggeForChat ---MessaggioCrud--- ");
			throw new Exception(Costanti.ERRORE_CARICAMENTO_MESSAGGI);
		}
	}
}
