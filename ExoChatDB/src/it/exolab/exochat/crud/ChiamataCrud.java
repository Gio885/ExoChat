package it.exolab.exochat.crud;

import it.exolab.exochat.model.Chiamata;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ChiamataCrud {


    @SuppressWarnings("unchecked")
	public List<Chiamata> findAllChiamateByUtenteId(int utenteId, EntityManager entityManager) {
        try {
            String queryString = "SELECT c FROM Chiamata c WHERE c.chiamanteId = :utenteId OR c.riceventeId = :utenteId";
            Query query = entityManager.createQuery(queryString);
            query.setParameter("utenteId", utenteId);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Errore durante il recupero delle chiamate per utente ID", e);
        }
    }

    @SuppressWarnings("unchecked")
	public List<Chiamata> findAllChiamateByGroupId(int gruppoId, EntityManager entityManager) {
        try {
            String queryString = "SELECT c FROM Chiamata c WHERE c.gruppoRiceventeId = :gruppoId";
            Query query = entityManager.createQuery(queryString);
            query.setParameter("gruppoId", gruppoId);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Errore durante il recupero delle chiamate per ID gruppo", e);
        }
    }

    public void insertChiamata(Chiamata chiamata, EntityManager entityManager) {
        try {
            entityManager.persist(chiamata);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Errore durante l'inserimento della chiamata", e);
        }
    }
}
