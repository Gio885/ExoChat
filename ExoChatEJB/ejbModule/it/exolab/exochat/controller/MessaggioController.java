package it.exolab.exochat.controller;

import it.exolab.exochat.ejbinterface.MessaggioControllerInterface;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class MessaggioController
 */
@Stateless(name = "MessaggioControllerInterface")
@LocalBean
public class MessaggioController implements MessaggioControllerInterface {

    /**
     * Default constructor. 
     */
    public MessaggioController() {
        // TODO Auto-generated constructor stub
    }

}
