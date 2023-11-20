package it.exolab.exochat.ejbinterface;

import it.exolab.exochat.dto.Dto;
import it.exolab.exochat.model.Chat;
import it.exolab.exochat.model.Messaggio;
import it.exolab.exochat.model.Utente;

import javax.ejb.Local;
import javax.persistence.EntityManager;

import java.util.List;

@Local
public interface MessaggioControllerInterface {

	List<Messaggio> findMessaggioByUtenteId(Integer utenteId) throws Exception;

    List<Messaggio> findMessaggioByGroupId(Integer gruppoId) throws Exception;

    void insertMessaggio(Messaggio messaggio) throws Exception;
    
    List<Messaggio> findLastMessaggeForChat (Utente utente) throws Exception;
    
	List<Messaggio> findMessaggiForChatId(Chat chat) throws Exception;


}
