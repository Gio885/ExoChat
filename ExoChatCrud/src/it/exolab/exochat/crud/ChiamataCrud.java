package it.exolab.exochat.crud;

import it.exolab.exochat.costanti.Costanti;
import it.exolab.exochat.model.Chiamata;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ChiamataCrud {


    @SuppressWarnings("unchecked")
	public List<Chiamata> findAllChiamateByUtenteId(Integer utenteId, EntityManager entityManager) throws Exception {
        try {
            String queryString = "SELECT c FROM Chiamata c WHERE c.chiamanteId = :utenteId OR c.riceventeId = :utenteId";
            Query query = entityManager.createQuery(queryString);
            query.setParameter("utenteId", utenteId);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Errore metodo findAllChiamateByUtenteId ---ChiamataCrud---");
            throw new Exception(Costanti.ERRORE_CARICAMENTO_CHIAMATE);
        }
    }

    @SuppressWarnings("unchecked")
	public List<Chiamata> findAllChiamateByGroupId(Integer gruppoId, EntityManager entityManager) throws Exception {
        try {
            String queryString = "SELECT c FROM Chiamata c WHERE c.gruppoRiceventeId = :gruppoId";
            Query query = entityManager.createQuery(queryString);
            query.setParameter("gruppoId", gruppoId);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Errore metodo findAllChiamateByGroupId ---ChiamataCrud---");
            throw new Exception(Costanti.ERRORE_CARICAMENTO_CHIAMATE);
        }
    }

    public Chiamata insertChiamata(Chiamata chiamata, EntityManager entityManager) throws Exception {
        try {
            entityManager.persist(chiamata);
            entityManager.flush();
            return chiamata;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Errore metodo insertChiamata ---ChiamataCrud---");
            throw new Exception(Costanti.ERRORE_CONTATTA_ASSISTENZA);
        }
    }
    
    public Chiamata updateChiamata(Chiamata chiamata,EntityManager entityManager) throws Exception {
    	try {
    		String queryString = "UPDATE Chiamata c SET c.dataOraFine = CURRENT_TIMESTAMP, c.durata = FUNC('TIMEDIFF', CURRENT_TIMESTAMP, c.dataOraInizio) WHERE c.idChiamata = :idChiamata";
    		Query query = entityManager.createQuery(queryString);
    		query.setParameter("idChiamata", chiamata.getIdChiamata());
    		Chiamata chiamataAggiornata = entityManager.find(Chiamata.class, chiamata.getIdChiamata());
    		return chiamataAggiornata;
    	}catch(Exception e) {
    		e.printStackTrace();
    		System.out.println("Errore metodo updateChiamata ---ChiamataCrud---");
    		throw new Exception(Costanti.ERRORE_CONTATTA_ASSISTENZA);
    	}
    }
    
}
