package it.exolab.exochat.crud;

import it.exolab.exochat.model.Gruppo;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class GruppoCrud {

    @SuppressWarnings("unchecked")
	public List<Gruppo> findAllGruppoByUtenteId(Long utenteId, EntityManager entityManager) {
        try {
            String queryString = "SELECT DISTINCT g FROM Gruppo g " +
                    "JOIN GruppoUtente gu ON g.idGruppo = gu.gruppo.idGruppo " +
                    "WHERE gu.utente.idUtente = :utenteId";
            Query query = entityManager.createQuery(queryString);
            query.setParameter("utenteId", utenteId);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Errore durante la ricerca dei gruppi per utente ID", e);
        }
    }

    public void insertGruppo(Gruppo gruppo, EntityManager entityManager) {
        try {
            entityManager.persist(gruppo);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Errore durante l'inserimento del gruppo", e);
        }
    }

    public Gruppo updateGruppo(Gruppo gruppo, EntityManager entityManager) {
        try {
            return entityManager.merge(gruppo);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Errore durante l'aggiornamento del gruppo", e);
        }
    }

    public void deleteGruppo(Long gruppoId, EntityManager entityManager) {
        try {
            Gruppo gruppo = entityManager.find(Gruppo.class, gruppoId);
            entityManager.remove(gruppo);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Errore durante l'eliminazione del gruppo", e);
        }
    }
}
