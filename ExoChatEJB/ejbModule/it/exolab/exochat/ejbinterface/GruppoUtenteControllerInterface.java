package it.exolab.exochat.ejbinterface;

import it.exolab.exochat.model.GruppoUtente;

import javax.ejb.Local;
import java.util.List;

@Local
public interface GruppoUtenteControllerInterface {

    void insertUtentiGruppo(List<GruppoUtente> gruppoUtente) throws Exception;
    
}
