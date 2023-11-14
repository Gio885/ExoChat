package it.exolab.exochat.crud;

import it.exolab.exochat.model.GruppoUtente;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class GruppoUtenteCrud {

    @SuppressWarnings("unchecked")
	public List<GruppoUtente> findAllUtenteByGroupId(Integer gruppoId, EntityManager entityManager) throws Exception {
    	
        try {
            String queryString = "SELECT gu FROM GruppoUtente gu WHERE gu.gruppo.idGruppo = :gruppoId";
            Query query = entityManager.createQuery(queryString);
            query.setParameter("gruppoId", gruppoId);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Errore findAllUtenteByGroupId --GruppoUtenteCrud--");
            throw new Exception("Errore durante la ricerca degli utenti per gruppo ID", e);
        }
    }

    @SuppressWarnings("unchecked")
	public List<GruppoUtente> findAllGroupByUtenteId(Integer utenteId, EntityManager entityManager) {
    	
        try {
            String queryString = "SELECT gu FROM GruppoUtente gu WHERE gu.utente.idUtente = :utenteId";
            Query query = entityManager.createQuery(queryString);
            query.setParameter("utenteId", utenteId);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Errore durante la ricerca dei gruppi per utente ID", e);
        }
    }

    public void insertGruppoUtente(GruppoUtente gruppoUtente, EntityManager entityManager) {
    	
        try {
            entityManager.persist(gruppoUtente);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Errore durante l'inserimento del legame gruppo-utente", e);
        }
    }

    public GruppoUtente updateGruppoUtente(GruppoUtente gruppoUtente, EntityManager entityManager) {
    	
        try {
            return entityManager.merge(gruppoUtente);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Errore durante l'aggiornamento del legame gruppo-utente", e);
        }
    }
    
    public void deleteGruppoUtente(GruppoUtente gruppoUtente, EntityManager entityManager) {
        try {
            GruppoUtente mergedGruppoUtente = entityManager.merge(gruppoUtente);
            entityManager.remove(mergedGruppoUtente);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Errore durante la cancellazione del legame gruppo-utente", e);
        }
    }
}
