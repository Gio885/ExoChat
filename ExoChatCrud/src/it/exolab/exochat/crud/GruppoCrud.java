package it.exolab.exochat.crud;

import it.exolab.exochat.costanti.Costanti;
import it.exolab.exochat.model.Gruppo;
import it.exolab.exochat.model.Utente;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class GruppoCrud extends BaseCrud <Gruppo> {

	
	private BaseCrud <Gruppo> baseCrud = new BaseCrud <Gruppo>();
	
	public Gruppo insertGruppo(Gruppo gruppo, EntityManager entityManager) throws Exception {
		try {
			return baseCrud.insert(gruppo, entityManager);		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Errore insertGruppo GruppoCrud ---Exception---");
			throw new Exception(Costanti.ERRORE_CREAZIONE_GRUPPO);
		}
	}

	   @SuppressWarnings("unchecked")
	    public List<Gruppo> findAllChatGruppoNonIniziate(Utente utente, EntityManager entityManager) throws Exception {
	        try {
	            String queryString = "SELECT DISTINCT g FROM Gruppo g INNER JOIN GruppoUtente gu"
	                    + " ON gu.gruppoId = g.idGruppo WHERE gu.utenteId = :idUtente AND"
	                    + " g.idGruppo NOT IN (SELECT m.gruppoId FROM Messaggio m WHERE g.idGruppo = m.gruppoId)";
	            Query query = entityManager.createQuery(queryString, Gruppo.class);
	            query.setParameter("idUtente", utente.getIdUtente());
	            return query.getResultList();
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("Errore findAllChatGruppoNonIniziate GruppoCrud ---Exception---");
	            throw new Exception(Costanti.ERRORE_CARICAMENTO_CHAT);
	        }


	    }
	
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   /*
    @SuppressWarnings("unchecked")
	public List<Gruppo> findAllGruppoByUtenteId(Integer utenteId, EntityManager entityManager) throws Exception {
        try {
            String queryString = "SELECT DISTINCT g FROM Gruppo g " +
                    "JOIN GruppoUtente gu ON g.idGruppo = gu.gruppo.idGruppo " +
                    "WHERE gu.utente.idUtente = :utenteId";
            Query query = entityManager.createQuery(queryString);
            query.setParameter("utenteId", utenteId);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Errore metodo findAllGruppoByUtenteId ---GruppoCrud---");
            throw new Exception(Costanti.ERRORE_CARICAMENTO_GRUPPI);
        }
    }
    
	public Gruppo updateGruppo(Gruppo gruppo, EntityManager entityManager) throws Exception {
		try {
			return baseCrud.update(gruppo, entityManager);
		} catch (Exception e) {
			System.out.println("Errore nel metodo updateGruppo della classe GruppoCrud ---Exception---");
			e.printStackTrace();
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}
	}
	
    public boolean deleteGruppo(Gruppo gruppoDaEliminare, EntityManager entityManager) throws Exception {
        try {
            return baseCrud.delete(gruppoDaEliminare, entityManager);
        } catch (Exception e) {
            e.printStackTrace();
			System.out.println("Errore nel metodo deleteGruppo della classe GruppoCrud ---Exception---");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CONTATTA_ASSISTENZA);
        }
    }
    */
}
