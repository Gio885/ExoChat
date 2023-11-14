package it.exolab.exochat.ejbinterface;

import it.exolab.exochat.model.GruppoUtente;

import javax.ejb.Local;
import java.util.List;

@Local
public interface GruppoUtenteControllerInterface {

    List<GruppoUtente> findAllUtenteByGroupId(int gruppoId);

    List<GruppoUtente> findAllGroupByUtenteId(int utenteId);

    void insertGruppoUtente(GruppoUtente gruppoUtente);

    void updateGruppoUtente(GruppoUtente gruppoUtente);

    void deleteGruppoUtente(GruppoUtente gruppoUtente);
}
