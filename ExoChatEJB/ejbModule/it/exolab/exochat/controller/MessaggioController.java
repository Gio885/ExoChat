package it.exolab.exochat.controller;

import it.exolab.exochat.costanti.Costanti;
import it.exolab.exochat.crud.MessaggioCrud;
import it.exolab.exochat.ejbinterface.MessaggioControllerInterface;
import it.exolab.exochat.model.Messaggio;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 * Session Bean implementation class MessaggioController
 */
@Stateless(name = "MessaggioControllerInterface")
@LocalBean
public class MessaggioController implements MessaggioControllerInterface {

    
	@PersistenceUnit(name = Costanti.PERSISTENCE_UNIT_NAME)
	private EntityManagerFactory entityManagerFactory;
	
    public MessaggioController() {
    	
    }

	@Override
	public List<Messaggio> findMessaggioByUtenteId(Integer utenteId) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			MessaggioCrud messaggioCrud = new MessaggioCrud();
			List<Messaggio> listaMessaggi = messaggioCrud.findMessaggioByUtenteId(utenteId, entityManager);
			return listaMessaggi;			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore findMessaggioByUtenteId --ControllerMessaggio--");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}
	}

	@Override
	public List<Messaggio> findMessaggioByGroupId(Integer gruppoId) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			MessaggioCrud messaggioCrud = new MessaggioCrud();
			List<Messaggio> listaMessaggiGruppo = messaggioCrud.findMessaggioByGroupId(gruppoId, entityManager);
			return listaMessaggiGruppo;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore findMessaggioByGroupId --ControllerMessaggio--");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}
	}

	@Override
	public void insertMessaggio(Messaggio messaggio) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			MessaggioCrud messaggioCrud = new MessaggioCrud();
			messaggioCrud.insertMessaggio(messaggio, entityManager);
			entityManager.getTransaction().commit();			
		}catch(Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			System.out.println("Errore insertMessaggio --ControllerMessaggio--");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}
	}

}
