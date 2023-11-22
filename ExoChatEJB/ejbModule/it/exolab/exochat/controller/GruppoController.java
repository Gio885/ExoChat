package it.exolab.exochat.controller;

import it.exolab.exochat.costanti.Costanti;
import it.exolab.exochat.crud.GruppoCrud;
import it.exolab.exochat.ejbinterface.GruppoControllerInterface;
import it.exolab.exochat.model.Gruppo;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 * Session Bean implementation class GruppoController
 */
@Stateless(name = "GruppoControllerInterface")
@LocalBean
public class GruppoController implements GruppoControllerInterface {

    @PersistenceUnit(name = Costanti.PERSISTENCE_UNIT_NAME)
    private EntityManagerFactory entityManagerFactory;
	
	
    public GruppoController() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Gruppo> findAllGruppoByUtenteId(Integer utenteId) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			GruppoCrud gruppoCrud = new GruppoCrud();
			List<Gruppo> listaGruppiUtente = gruppoCrud.findAllGruppoByUtenteId(utenteId, entityManager);
			return listaGruppiUtente;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore metodo findAllGruppoByUtenteId ---GruppoController--- ");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CARICAMENTO_GRUPPI);
		}finally {
			entityManager.clear();
			entityManager.close();
		}
	}

	@Override
	public Gruppo insertGruppo(Gruppo gruppo) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			GruppoCrud gruppoCrud = new GruppoCrud();
			entityManager.getTransaction().begin();
			Gruppo gruppoInserito = gruppoCrud.insert(gruppo, entityManager);
			entityManager.getTransaction().commit();
			return gruppoInserito;
		}catch(Exception e) {
			e.printStackTrace();
			entityManager.close();
			System.out.println("Errore metodo insertGruppo ---GruppoController--- ");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}finally {
			entityManager.clear();
			entityManager.close();
		}
	}

	@Override
	public Gruppo updateGruppo(Gruppo gruppo) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			GruppoCrud gruppoCrud = new GruppoCrud();
			entityManager.getTransaction().begin();
			Gruppo gruppoAggiornato = gruppoCrud.updateGruppo(gruppo, entityManager);
			entityManager.getTransaction().commit();
			return gruppoAggiornato;
		}catch(Exception e) {
			e.printStackTrace();
			entityManager.close();
			System.out.println("Errore metodo updateGruppo ---GruppoController--- ");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}finally {
			entityManager.clear();
			entityManager.close();
		}		
	}

	@Override
	public void deleteGruppo(Gruppo gruppo) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			GruppoCrud gruppoCrud = new GruppoCrud();
			entityManager.getTransaction().begin();
			gruppoCrud.deleteGruppo(gruppo.getIdGruppo(), entityManager);
			entityManager.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			entityManager.close();
			System.out.println("Errore metodo updateGruppo ---GruppoController--- ");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}finally {
			entityManager.clear();
			entityManager.close();
		}
		
	}

}
