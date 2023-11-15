package it.exolab.exochat.controller;

import it.exolab.exochat.ejbinterface.ChatControllerInterface;
import it.exolab.exochat.model.Chat;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class ChatController
 */
@Stateless(name = "ChatControllerInterface")
@LocalBean
public class ChatController implements ChatControllerInterface {

    /**
     * Default constructor. 
     */
    public ChatController() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Chat> findAllChatByUtenteId(Integer utenteId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertChat(Chat chat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteChat(Chat chat) {
		// TODO Auto-generated method stub
		
	}

}
