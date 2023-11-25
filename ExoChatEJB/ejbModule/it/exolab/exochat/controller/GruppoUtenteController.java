package it.exolab.exochat.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import it.exolab.exochat.costanti.Costanti;
import it.exolab.exochat.crud.GruppoUtenteCrud;
import it.exolab.exochat.ejbinterface.GruppoUtenteControllerInterface;
import it.exolab.exochat.entitymanagerprovider.EntityManagerProvider;
import it.exolab.exochat.model.GruppoUtente;

/**
 * Session Bean implementation class GruppoUtenteController
 */
@Stateless(name = "GruppoUtenteControllerInterface")
@LocalBean
public class GruppoUtenteController extends EntityManagerProvider implements GruppoUtenteControllerInterface {

    public GruppoUtenteController() {
        // TODO Auto-generated constructor stub
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
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_INSERIMENTO_UTENTI_GRUPPO);
		}finally {
			entityManager.clear();
			entityManager.close();
		}		
	}

}
