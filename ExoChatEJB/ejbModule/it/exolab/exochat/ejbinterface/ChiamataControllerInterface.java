package it.exolab.exochat.ejbinterface;

import it.exolab.exochat.model.Chiamata;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ChiamataControllerInterface {

    List<Chiamata> findAllChiamateByUtenteId(Integer utenteId) throws Exception;

    List<Chiamata> findAllChiamateByGroupId(Integer gruppoId) throws Exception;

    Chiamata insertChiamata(Chiamata chiamata) throws Exception;
    
    Chiamata updataChiamata(Chiamata chiamata) throws Exception;
}
