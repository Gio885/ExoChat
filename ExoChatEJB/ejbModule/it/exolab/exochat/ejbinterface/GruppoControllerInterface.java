package it.exolab.exochat.ejbinterface;

import it.exolab.exochat.dto.AccountDto;
import it.exolab.exochat.dto.Dto;
import it.exolab.exochat.model.*;

import javax.ejb.Local;
import java.util.List;

@Local
public interface GruppoControllerInterface {

    Dto<List<Gruppo>> findAllChatGruppoNonIniziate(Utente utente) throws Exception;

    Dto<Gruppo> insertGruppo(AccountDto gruppo) throws Exception;

    //Gruppo updateGruppo(Gruppo gruppo) throws Exception;

    //void deleteGruppo(Gruppo gruppo) throws Exception;
    
    //List<Gruppo> findAllGruppoByUtenteId(Integer utenteId) throws Exception;

}
