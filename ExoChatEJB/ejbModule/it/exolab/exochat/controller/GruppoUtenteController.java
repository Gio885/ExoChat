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
			List <GruppoUtente> gruppoUtente = gruppoUtenteCrud.findAllUtenteByGroupId(gruppoId, entityManager);
			return gruppoUtente;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore metodo findAllUtenteByGroupId ----gruppoUtenteController----  ");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CARICAMENTO_UTENTI);
		}finally {
			entityManager.close();
		}
	}

	@Override
	public List<GruppoUtente> findAllGroupByUtenteId(Integer utenteId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertGruppoUtente(GruppoUtente gruppoUtente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateGruppoUtente(GruppoUtente gruppoUtente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteGruppoUtente(GruppoUtente gruppoUtente) {
		// TODO Auto-generated method stub
		
	}

}
