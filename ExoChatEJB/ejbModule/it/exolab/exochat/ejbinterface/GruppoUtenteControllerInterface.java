package it.exolab.exochat.ejbinterface;

import it.exolab.exochat.model.GruppoUtente;

import javax.ejb.Local;
import java.util.List;

@Local
public interface GruppoUtenteControllerInterface {

    List<GruppoUtente> findAllUtenteByGroupId(Integer gruppoId) throws Exception;

    List<GruppoUtente> findAllGroupByUtenteId(Integer utenteId) throws Exception;

    void insertUtentiGruppo(List<GruppoUtente> gruppoUtente) throws Exception;

    GruppoUtente updateGruppoUtente(GruppoUtente gruppoUtente) throws Exception;

    void deleteGruppoUtente(GruppoUtente gruppoUtente) throws Exception;
}
