package it.exolab.exochat.crud;

import it.exolab.exochat.model.Messaggio;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class MessaggioCrud {

    @SuppressWarnings("unchecked")
	public List<Messaggio> findMessaggioByUtenteId(int utenteId, EntityManager entityManager) {
        try {
            String queryString = "SELECT m FROM Messaggio m WHERE m.mittente.idUtente = :utenteId OR m.destinatario.idUtente = :utenteId GROUP BY m.chat.idChat";
            Query query = entityManager.createQuery(queryString);
            query.setParameter("utenteId", utenteId);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Errore durante la ricerca dei messaggi per utente ID", e);
        }
    }

    @SuppressWarnings("unchecked")
	public List<Messaggio> findMessaggioByGroupId(int gruppoId, EntityManager entityManager) {
        try {
            String queryString = "SELECT m FROM Messaggio m WHERE m.gruppo.idGruppo = :gruppoId";
            Query query = entityManager.createQuery(queryString);
            query.setParameter("gruppoId", gruppoId);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Errore durante la ricerca dei messaggi per gruppo ID", e);
        }
    }

    public void insertMessaggio(Messaggio messaggio, EntityManager entityManager) {
        try {
            entityManager.persist(messaggio);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Errore durante l'inserimento del messaggio", e);
        }
    }
}

