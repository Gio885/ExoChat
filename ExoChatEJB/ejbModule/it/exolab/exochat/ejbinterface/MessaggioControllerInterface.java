package it.exolab.exochat.ejbinterface;

import it.exolab.exochat.dto.Dto;
import it.exolab.exochat.model.Messaggio;

import javax.ejb.Local;
import java.util.List;

@Local
public interface MessaggioControllerInterface {

	Dto<Messaggio> findMessaggioByUtenteId(Integer utenteId) throws Exception;

    List<Messaggio> findMessaggioByGroupId(Integer gruppoId) throws Exception;

    void insertMessaggio(Messaggio messaggio) throws Exception;
}
