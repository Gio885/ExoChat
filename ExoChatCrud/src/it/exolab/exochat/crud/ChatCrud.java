package it.exolab.exochat.crud;

import it.exolab.exochat.costanti.Costanti;
import it.exolab.exochat.model.Chat;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ChatCrud extends BaseCrud<Chat>{
	
	private BaseCrud<Chat> baseCrud = new BaseCrud<Chat>();

    @SuppressWarnings("unchecked")
	public List<Chat> findChatByUtenteId(Integer utenteId, EntityManager entityManager) throws Exception {
    	
        try {
            String queryString = "SELECT DISTINCT c FROM Chat c " +
                    "JOIN Messaggio m ON c.idChat = m.chat.idChat " +
                    "WHERE m.mittente.idUtente = :utenteId OR m.destinatario.idUtente = :utenteId";
            Query query = entityManager.createQuery(queryString);
            query.setParameter("utenteId", utenteId);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Errore metodo findChatByUtenteId ---ChatCrud---");
            throw new Exception(Costanti.ERRORE_CARICAMENTO_CHAT);
        }
    }

    public Chat insertChat(Chat chat, EntityManager entityManager) throws Exception {   	
        try {
        	return baseCrud.insert(chat, entityManager);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Errore metodo insertChat ---ChatCrud---");
            throw new Exception(Costanti.ERRORE_CONTATTA_ASSISTENZA);
        }
    }

    public boolean deleteChat(Chat chat, EntityManager entityManager) throws Exception {
    	
        try {
        	return baseCrud.delete(chat, entityManager);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Errore metodo deleteChat ---ChatCrud---");
            throw new Exception(Costanti.ERRORE_CONTATTA_ASSISTENZA);
        }
    }
}
