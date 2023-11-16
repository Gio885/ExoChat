package it.exolab.exochat.crud;

import it.exolab.exochat.costanti.Costanti;
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
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Errore insertMessaggio --MessaggioCrud--");
            throw new Exception(Costanti.ERRORE_CONTATTA_ASSISTENZA);
        }
    }
    
    /*
"SELECT messaggio.chat.idChat, messaggio.contenutoMessaggio, messaggio.dataOra " +
                         "FROM Messaggio messaggio " +
                         "JOIN (SELECT chat.idChat, MAX(messaggio.dataOra) AS max_data_ora " +
                         "      FROM Messaggio messaggio " +
                         "      WHERE messaggio.mittente.idUtente = :utenteId OR messaggio.destinatario.idUtente = :utenteId " +
                         "      GROUP BY messaggio.chat.idChat) messaggi_recenti " +
                         "ON messaggio.chat.idChat = messaggi_recenti.chat.idChat AND messaggio.dataOra = messaggi_recenti.max_data_ora " +
                         "ORDER BY messaggio.dataOra DESC";
     */
    
    @SuppressWarnings("unchecked")
	public List<Messaggio> findLastMessaggeForChat(Utente utente,EntityManager entityManager) throws Exception {
    	try {
    		String queryString = 
    				"SELECT messaggio.chat.idChat, messaggio.contenutoMessaggio, messaggio.dataOra " +
                    "FROM Messaggio messaggio " +
                    "JOIN (SELECT chat.idChat, MAX(messaggio.dataOra) AS max_data_ora " +
                    "FROM Messaggio messaggio " +
                    "WHERE messaggio.mittente.idUtente = :utenteId OR messaggio.destinatario.idUtente = :utenteId " +
                    "GROUP BY messaggio.chat.idChat) messaggi_recenti " +
                    "ON messaggio.chat.idChat = messaggi_recenti.chat.idChat AND messaggio.dataOra = messaggi_recenti.max_data_ora " +
                    "ORDER BY messaggio.dataOra DESC";
    		Query query = entityManager.createQuery(queryString);
            query.setParameter("utenteId", utente.getIdUtente());
    		return query.getResultList();
    	}catch(Exception e) {
    		e.printStackTrace();
    		System.out.println("Errore metodo findLastMessaggeForChat ---MessaggioCrud--- ");
    		throw new Exception(Costanti.ERRORE_CARICAMENTO_MESSAGGI);
    	}
    }
}

