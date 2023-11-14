package it.exolab.exochat.crud;

import it.exolab.exochat.model.Chat;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ChatCrud {

    @SuppressWarnings("unchecked")
	public List<Chat> findChatByUtenteId(int utenteId, EntityManager entityManager) {
    	
        try {
            String queryString = "SELECT DISTINCT c FROM Chat c " +
                    "JOIN Messaggio m ON c.idChat = m.chat.idChat " +
                    "WHERE m.mittente.idUtente = :utenteId OR m.destinatario.idUtente = :utenteId";
            Query query = entityManager.createQuery(queryString);
            query.setParameter("utenteId", utenteId);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Errore durante la ricerca delle chat per utente ID", e);
        }
    }

    public void insertChat(Chat chat, EntityManager entityManager) {
    	
        try {
            entityManager.persist(chat);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Errore durante l'inserimento della chat", e);
        }
    }

    public void deleteChat(int chatId, EntityManager entityManager) {
    	
        try {
            Chat chat = entityManager.find(Chat.class, chatId);
            entityManager.remove(chat);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Errore durante l'eliminazione della chat", e);
        }
    }
}
