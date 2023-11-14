package it.exolab.exochat.ejbinterface;

import it.exolab.exochat.model.Gruppo;

import javax.ejb.Local;
import java.util.List;

@Local
public interface GruppoControllerInterface {

    List<Gruppo> findAllGruppoByUtenteId(Integer utenteId);

    void insertGruppo(Gruppo gruppo);

    void updateGruppo(Gruppo gruppo);

    void deleteGruppo(Gruppo gruppo);
}
