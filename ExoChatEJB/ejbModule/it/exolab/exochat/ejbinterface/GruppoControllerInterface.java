package it.exolab.exochat.ejbinterface;

import it.exolab.exochat.model.Gruppo;

import javax.ejb.Local;
import java.util.List;

@Local
public interface GruppoControllerInterface {

    List<Gruppo> findAllGruppoByUtenteId(Integer utenteId) throws Exception;

    Gruppo insertGruppo(Gruppo gruppo) throws Exception;

    Gruppo updateGruppo(Gruppo gruppo) throws Exception;

    void deleteGruppo(Gruppo gruppo) throws Exception;
}
