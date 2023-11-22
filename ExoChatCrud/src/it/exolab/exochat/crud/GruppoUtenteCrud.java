package it.exolab.exochat.crud;

import it.exolab.exochat.costanti.Costanti;
import it.exolab.exochat.model.Gruppo;
import it.exolab.exochat.model.GruppoUtente;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class GruppoUtenteCrud extends BaseCrud <GruppoUtente> {

	
	private BaseCrud <GruppoUtente> baseCrud = new BaseCrud <GruppoUtente>();
	
	
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
            throw new Exception(Costanti.ERRORE_CARICAMENTO_UTENTI);
        }
    }

    @SuppressWarnings("unchecked")
	public List<GruppoUtente> findAllGroupByUtenteId(Integer utenteId, EntityManager entityManager) throws Exception {
    	
        try {
            String queryString = "SELECT gu FROM GruppoUtente gu WHERE gu.utente.idUtente = :utenteId";
            Query query = entityManager.createQuery(queryString);
            query.setParameter("utenteId", utenteId);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Errore findAllGroupByUtenteId ---GruppoUtenteCrud--- ");
            throw new Exception(Costanti.ERRORE_CARICAMENTO_GRUPPI);
        }
    }

    public void insertGruppoUtente(List<GruppoUtente> listaUtentiGruppo, EntityManager entityManager) throws Exception {
        try {
        	for(GruppoUtente utenteDaAssociareAlGruppo : listaUtentiGruppo) {
                baseCrud.insert(utenteDaAssociareAlGruppo, entityManager);
                entityManager.clear();
        	}
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Errore insertGruppoUtente ---GruppoUtenteCrud");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CONTATTA_ASSISTENZA);
        }
    }

    public GruppoUtente updateGruppoUtente(GruppoUtente gruppoUtente, EntityManager entityManager) throws Exception {    	
        try {
            return baseCrud.update(gruppoUtente, entityManager);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Errore updateGruppoUtente ---GruppoUtenteCrud");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CONTATTA_ASSISTENZA);
        }
    }
    
    public boolean deleteGruppoUtente(GruppoUtente gruppoUtente, EntityManager entityManager) throws Exception {
        try {
            return baseCrud.delete(gruppoUtente, entityManager);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Errore deleteGruppoUtente ---GruppoUtenteCrud");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CONTATTA_ASSISTENZA);
        }
    }
}
