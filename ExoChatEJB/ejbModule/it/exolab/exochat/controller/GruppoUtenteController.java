package it.exolab.exochat.controller;

import it.exolab.exochat.ejbinterface.GruppoUtenteControllerInterface;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class GruppoUtenteController
 */
@Stateless(name = "GruppoUtenteControllerInterface")
@LocalBean
public class GruppoUtenteController implements GruppoUtenteControllerInterface {

    /**
     * Default constructor. 
     */
    public GruppoUtenteController() {
        // TODO Auto-generated constructor stub
    }

}
