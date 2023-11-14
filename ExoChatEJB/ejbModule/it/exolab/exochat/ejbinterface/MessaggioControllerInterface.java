package it.exolab.exochat.ejbinterface;

import it.exolab.exochat.model.Messaggio;

import javax.ejb.Local;
import java.util.List;

@Local
public interface MessaggioControllerInterface {

    List<Messaggio> findMessaggioByUtenteId(int utenteId);

    List<Messaggio> findMessaggioByGroupId(int gruppoId);

    void insertMessaggio(Messaggio messaggio);
}
