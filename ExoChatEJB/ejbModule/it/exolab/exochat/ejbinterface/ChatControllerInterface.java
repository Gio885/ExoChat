package it.exolab.exochat.ejbinterface;

import javax.ejb.Local;

import it.exolab.exochat.model.Chat;

@Local
public interface ChatControllerInterface {

    Chat insertChat(Chat chat) throws Exception;

//    void deleteChat(Chat chat) throws Exception;
//    
//    List<Chat> findAllChatByUtenteId(Integer utenteId) throws Exception;

}
