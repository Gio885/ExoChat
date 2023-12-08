package it.exolab.exochat.ejbinterface;

import java.util.List;

import javax.ejb.Local;

import it.exolab.exochat.dto.Dto;
import it.exolab.exochat.dto.MessaggioDto;
import it.exolab.exochat.model.Chat;
import it.exolab.exochat.model.Messaggio;
import it.exolab.exochat.model.Utente;

@Local
public interface MessaggioControllerInterface {

    void insertMessaggio(MessaggioDto messaggio) throws Exception;
    
    Dto<List<Messaggio>> findLastMessaggeForChat (Utente utente) throws Exception;
    
    Dto<List<Messaggio>> findMessaggiForChatId(Chat chat) throws Exception;

  //List<Messaggio> findMessaggioByUtenteId(Integer utenteId) throws Exception;

    //List<Messaggio> findMessaggioByGroupId(Integer gruppoId) throws Exception;

}
