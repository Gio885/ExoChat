package it.exolab.exochat.ejbinterface;

import it.exolab.exochat.dto.Dto;
import it.exolab.exochat.model.Utente;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UtenteControllerInterface {

	Dto <List<Utente>> findAllUtenti() throws Exception;

	Dto<Utente> findUtenteById(Integer idUtente) throws Exception;

	Dto<Utente> findUtenteByUsername(String username) throws Exception;

	Dto<Utente> updateUtente(Utente utente) throws Exception;

    void deleteUtente(Utente utente) throws Exception;

    Dto <Utente> insertUtente(Utente utente) throws Exception;
}
