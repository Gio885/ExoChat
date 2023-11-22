package it.exolab.exochat.controller;

import it.exolab.exochat.costanti.Costanti;
import it.exolab.exochat.crud.GruppoUtenteCrud;
import it.exolab.exochat.ejbinterface.GruppoUtenteControllerInterface;
import it.exolab.exochat.model.GruppoUtente;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 * Session Bean implementation class GruppoUtenteController
 */
@Stateless(name = "GruppoUtenteControllerInterface")
@LocalBean
public class GruppoUtenteController implements GruppoUtenteControllerInterface {

    @PersistenceUnit(name = Costanti.PERSISTENCE_UNIT_NAME)
    private EntityManagerFactory entityManagerFactory;
	
    public GruppoUtenteController() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<GruppoUtente> findAllUtenteByGroupId(Integer gruppoId) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			GruppoUtenteCrud gruppoUtenteCrud = new GruppoUtenteCrud();
			List <GruppoUtente> utentiGruppo = gruppoUtenteCrud.findAllUtenteByGroupId(gruppoId, entityManager);
			return utentiGruppo;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore metodo findAllUtenteByGroupId ----gruppoUtenteController----  ");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CARICAMENTO_UTENTI);
		}finally {
			entityManager.clear();
			entityManager.close();
		}
	}

	@Override
	public List<GruppoUtente> findAllGroupByUtenteId(Integer utenteId) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			GruppoUtenteCrud gruppoUtenteCrud = new GruppoUtenteCrud();
			List<GruppoUtente> gruppiUtente = gruppoUtenteCrud.findAllGroupByUtenteId(utenteId, entityManager);
			return gruppiUtente;			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore metodo findAllGroupByUtenteId ---GruppoUtenteController---");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CARICAMENTO_GRUPPI);
		}finally {
			entityManager.clear();
			entityManager.close();
		}
	}

	@Override
	public void insertUtentiGruppo(List<GruppoUtente> gruppoUtente) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			GruppoUtenteCrud gruppoUtenteCrud = new GruppoUtenteCrud();
			entityManager.getTransaction().begin();	
			gruppoUtenteCrud.insertGruppoUtente(gruppoUtente, entityManager);
			entityManager.getTransaction().commit();			
		}catch(Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			System.out.println("Errore metodo insertGruppoUtente ---GruppoUtenteController---");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}finally {
			entityManager.clear();
			entityManager.close();
		}		
	}

	@Override
	public GruppoUtente updateGruppoUtente(GruppoUtente gruppoUtente) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			GruppoUtenteCrud gruppoUtenteCrud = new GruppoUtenteCrud();
			entityManager.getTransaction().begin();
			GruppoUtente gruppoAggiornato = gruppoUtenteCrud.updateGruppoUtente(gruppoUtente, entityManager);
			entityManager.getTransaction().commit();
			return gruppoAggiornato;			
		}catch(Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			System.out.println("Errore metodo updateGruppoUtente ---GruppoUtenteController---");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}finally {
			entityManager.clear();
			entityManager.close();
		}	
	}

	@Override
	public void deleteGruppoUtente(GruppoUtente gruppoUtente) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			GruppoUtenteCrud gruppoUtenteCrud = new GruppoUtenteCrud();
			entityManager.getTransaction().begin();
			gruppoUtenteCrud.deleteGruppoUtente(gruppoUtente, entityManager);
			entityManager.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			System.out.println("Errore metodo deleteGruppoUtente ---GruppoUtenteController---");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}finally {
			entityManager.clear();
			entityManager.close();
		}		
	}

}
