package it.exolab.exochat.ejbinterface;

import it.exolab.exochat.model.Chat;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ChatControllerInterface {

    List<Chat> findAllChatByUtenteId(Integer utenteId) throws Exception;

    Chat insertChat(Chat chat) throws Exception;

    void deleteChat(Chat chat) throws Exception;
}
