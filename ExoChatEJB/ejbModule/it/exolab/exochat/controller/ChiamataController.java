package it.exolab.exochat.controller;

import it.exolab.exochat.costanti.Costanti;
import it.exolab.exochat.crud.ChiamataCrud;
import it.exolab.exochat.ejbinterface.ChiamataControllerInterface;
import it.exolab.exochat.entitymanagerprovider.EntityManagerProvider;
import it.exolab.exochat.model.Chiamata;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 * Session Bean implementation class ChiamataController
 */
@Stateless(name = "ChiamataControllerInterface")
@LocalBean
public class ChiamataController extends EntityManagerProvider implements ChiamataControllerInterface {

    
    public ChiamataController() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Chiamata> findAllChiamateByUtenteId(Integer utenteId) throws Exception {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		try {
			ChiamataCrud chiamataCrud = new ChiamataCrud();
			List<Chiamata> chiamateUtente = chiamataCrud.findAllChiamateByUtenteId(utenteId, entityManager);
			return chiamateUtente;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore metodo findAllChiamateByUtenteId ---ChiamataCrud--- ");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CARICAMENTO_CHIAMATE);
		}finally {
			entityManager.clear();
			entityManager.close();
		}
	}

	@Override
	public List<Chiamata> findAllChiamateByGroupId(Integer gruppoId) throws Exception {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		try {
			ChiamataCrud chiamataCrud = new ChiamataCrud();
			List<Chiamata> chiamateDiGruppo = chiamataCrud.findAllChiamateByGroupId(gruppoId, entityManager);
			return chiamateDiGruppo;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore metodo findAllChiamateByGroupId ---ChiamataCrud--- ");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CARICAMENTO_CHIAMATE);
		}finally {
			entityManager.clear();
			entityManager.close();
		}
	}

	@Override
	public Chiamata insertChiamata(Chiamata chiamata) throws Exception {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		try {
			ChiamataCrud chiamataCrud = new ChiamataCrud();
			entityManager.getTransaction().begin();
			Chiamata chiamataInserita = chiamataCrud.insertChiamata(chiamata, entityManager);
			entityManager.getTransaction().commit();
			return chiamataInserita;
		}catch(Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			System.out.println("Errore metodo insertChiamata ---ChiamataCrud--- ");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}finally {
			entityManager.clear();
			entityManager.close();
		}	
	}

	@Override
	public Chiamata updataChiamata(Chiamata chiamata) throws Exception {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		try {
			ChiamataCrud chiamataCrud = new ChiamataCrud();
			entityManager.getTransaction().begin();
			Chiamata chiamataAggiornata = chiamataCrud.updateChiamata(chiamata, entityManager);
			entityManager.getTransaction().commit();
			return chiamataAggiornata;
		}catch(Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			System.out.println("Errore metodo updataChiamata ---ChiamataCrud--- ");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}finally {
			entityManager.clear();
			entityManager.close();
		}
	}


}
