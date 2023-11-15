package it.exolab.exochat.controller;

import it.exolab.exochat.ejbinterface.ChiamataControllerInterface;
import it.exolab.exochat.model.Chiamata;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class ChiamataController
 */
@Stateless(name = "ChiamataControllerInterface")
@LocalBean
public class ChiamataController implements ChiamataControllerInterface {

    /**
     * Default constructor. 
     */
    public ChiamataController() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Chiamata> findAllChiamateByUtenteId(Integer utenteId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Chiamata> findAllChiamateByGroupId(Integer gruppoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertChiamata(Chiamata chiamata) {
		// TODO Auto-generated method stub
		
	}

}
