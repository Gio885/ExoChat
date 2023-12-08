package it.exolab.exochat.ejbinterface;

import java.util.List;
import javax.ejb.Local;
import it.exolab.exochat.dto.AccountDto;
import it.exolab.exochat.dto.Dto;
import it.exolab.exochat.model.Utente;

@Local
public interface UtenteControllerInterface {
	
	Dto <Utente> findUtenteByEmailAndPassword(Utente utente) throws Exception;
	
    Dto <Utente> insertUtente(Utente utente) throws Exception;
    
	Dto<Utente> updateUtente(AccountDto utente) throws Exception;

	Dto <List<Utente>> findAllUtenti() throws Exception;

	Dto <List<Utente>> findAllUtentiChatNonIniziate(Utente utente) throws Exception;
	
	Utente findById(Integer id) throws Exception;


    
    
  //Dto<Utente> findUtenteById(Integer idUtente) throws Exception;

  	//Dto<Utente> findUtenteByUsername(String username) throws Exception;
    
    //void deleteUtente(Utente utente) throws Exception;

    
}
