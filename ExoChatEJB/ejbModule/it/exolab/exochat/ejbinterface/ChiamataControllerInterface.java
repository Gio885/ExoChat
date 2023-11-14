package it.exolab.exochat.ejbinterface;

import it.exolab.exochat.model.Chiamata;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ChiamataControllerInterface {

    List<Chiamata> findAllChiamateByUtenteId(Integer utenteId);

    List<Chiamata> findAllChiamateByGroupId(Integer gruppoId);

    void insertChiamata(Chiamata chiamata);
}
