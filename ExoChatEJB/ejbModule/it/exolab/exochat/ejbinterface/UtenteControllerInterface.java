package it.exolab.exochat.ejbinterface;

import it.exolab.exochat.model.Utente;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UtenteControllerInterface {

    List<Utente> findAllUtenti();

    Utente findUtenteById(int idUtente);

    Utente findUtenteByUsername(String username);

    Utente updateUtente(Utente utente);

    void deleteUtente(Utente utente);

    void insertUtente(Utente utente);
}
