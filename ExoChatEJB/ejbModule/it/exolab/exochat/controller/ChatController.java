package it.exolab.exochat.controller;

import it.exolab.exochat.ejbinterface.ChatControllerInterface;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class ChatController
 */
@Stateless
@LocalBean
public class ChatController implements ChatControllerInterface {

    /**
     * Default constructor. 
     */
    public ChatController() {
        // TODO Auto-generated constructor stub
    }

}
