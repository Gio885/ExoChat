package it.exolab.exochat.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import it.exolab.exochat.conf.EjbService;
import it.exolab.exochat.costanti.Costanti;
import it.exolab.exochat.ejbinterface.GruppoUtenteControllerInterface;
import it.exolab.exochat.endpoint.EndPoint;
import it.exolab.exochat.model.GruppoUtente;

@Path(EndPoint.GRUPPO_UTENTE_REST)
public class GruppoUtenteRest {

	
	@POST
	@Path(EndPoint.INSERT_UTENTI_GRUPPO)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertUtentiInGruppo(List<GruppoUtente> listaUtentiGruppoDaInserire) {
		try {
			GruppoUtenteControllerInterface gruppoService = new EjbService<GruppoUtenteControllerInterface>(GruppoUtenteControllerInterface.class).getEJB();
			gruppoService.insertUtentiGruppo(listaUtentiGruppoDaInserire);
			return Response.status(Status.OK).build();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore metodo insertUtentiInGruppo ----GruppoUtenteRest----");
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_INSERIMENTO_UTENTI_GRUPPO).build();
		}		
	}
}
