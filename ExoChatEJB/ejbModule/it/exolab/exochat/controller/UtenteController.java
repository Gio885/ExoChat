package it.exolab.exochat.controller;

import it.exolab.exochat.crud.UtenteCrud;
import it.exolab.exochat.ejbinterface.UtenteControllerInterface;
import it.exolab.exochat.model.Utente;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 * Session Bean implementation class UtenteController
 */
@Stateless(name = "UtenteControllerInterface")
@LocalBean
public class UtenteController implements UtenteControllerInterface {

	@PersistenceUnit(name = "PersistenceUnit")
	private EntityManagerFactory entityManagerFactory;
	
	public UtenteController() {
		
	}

	@Override
	public Utente findUtente(Utente utente) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			UtenteCrud crud = new UtenteCrud();
			Utente utenteDaTrovare = crud.findUtente(utente, entityManager);
			return utenteDaTrovare;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
			throw new Exception();
		} finally {
			entityManager.close();
		}

	}

	@Override
	public void insertUtente(Utente utente) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			UtenteCrud crud = new UtenteCrud();
			crud.insertUtente(utente, entityManager);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
			throw new Exception();
		} finally {
			entityManager.close();
		}
		
	}
	
	
	
	

}
