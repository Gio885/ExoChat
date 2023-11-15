package it.exolab.exochat.controller;

import it.exolab.exochat.ejbinterface.GruppoControllerInterface;
import it.exolab.exochat.model.Gruppo;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class GruppoController
 */
@Stateless(name = "GruppoControllerInterface")
@LocalBean
public class GruppoController implements GruppoControllerInterface {

    /**
     * Default constructor. 
     */
    public GruppoController() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Gruppo> findAllGruppoByUtenteId(Integer utenteId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertGruppo(Gruppo gruppo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateGruppo(Gruppo gruppo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteGruppo(Gruppo gruppo) {
		// TODO Auto-generated method stub
		
	}

}
