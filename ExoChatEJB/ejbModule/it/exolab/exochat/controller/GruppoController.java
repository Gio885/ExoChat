package it.exolab.exochat.controller;

import it.exolab.exochat.ejbinterface.GruppoControllerInterface;
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

}
