package it.exolab.exochat.ejbinterface;

import it.exolab.exochat.model.Chat;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ChatControllerInterface {

    List<Chat> findAllChatByUtenteId(int utenteId);

    void insertChat(Chat chat);

    void deleteChat(Chat chat);
}
