package it.exolab.exochat.ejbinterface;

import it.exolab.exochat.dto.Dto;
import it.exolab.exochat.dto.MessaggioDto;
import it.exolab.exochat.model.Chat;
import it.exolab.exochat.model.Messaggio;
import it.exolab.exochat.model.Utente;

import javax.ejb.Local;

import java.util.List;

@Local
public interface MessaggioControllerInterface {

	//List<Messaggio> findMessaggioByUtenteId(Integer utenteId) throws Exception;

    //List<Messaggio> findMessaggioByGroupId(Integer gruppoId) throws Exception;

    void insertMessaggio(Messaggio messaggio) throws Exception;
    
    Dto<List<MessaggioDto>> findLastMessaggeForChat (Utente utente) throws Exception;
    
    Dto<List<MessaggioDto>> findMessaggiForChatId(Chat chat) throws Exception;


}
