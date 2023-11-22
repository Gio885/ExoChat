package it.exolab.exochat.crud;

import it.exolab.exochat.costanti.Costanti;
import it.exolab.exochat.model.Gruppo;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class GruppoCrud extends BaseCrud <Gruppo> {

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
            return entityManager.merge(gruppo);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Errore metodo updateGruppo ---GruppoCrud---");
            throw new Exception(Costanti.ERRORE_CONTATTA_ASSISTENZA);
        }
    }

    public void deleteGruppo(Integer gruppoId, EntityManager entityManager) throws Exception {
        try {
            Gruppo gruppo = entityManager.find(Gruppo.class, gruppoId);
            entityManager.remove(gruppo);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Errore metodo deleteGruppo ---GruppoCrud---");
            throw new Exception(Costanti.ERRORE_CONTATTA_ASSISTENZA);
        }
    }

	@Override
	public Gruppo insert(Gruppo gruppo, EntityManager entityManager) throws Exception {
		try {
			entityManager.persist(gruppo);
			entityManager.flush();
			entityManager.clear();
			return gruppo;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Errore insertMessaggio --MessaggioCrud--");
			throw new Exception(Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}
	}

	@Override
	public Gruppo update(Gruppo gruppo, EntityManager entityManager) throws Exception {
		try {
			if (!entityManager.contains(gruppo)) {
				gruppo = entityManager.merge(gruppo);
			}
			entityManager.flush();
			entityManager.clear();
			return gruppo;
		} catch (Exception e) {
			System.out.println("Errore nel metodo updateUtente della classe UtenteCrud ---Exception---");
			e.printStackTrace();
			throw new Exception(Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}
	}

	@Override
	public boolean delete(Gruppo oggetto, EntityManager entityManager) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
}
