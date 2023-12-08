package it.exolab.exochat.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import it.exolab.exochat.endpoint.EndPoint;
import it.exolab.exochat.model.Utente;

@Path(EndPoint.UTENTE_REST)
public interface UtenteRestInterface {

	@POST
	@Path(EndPoint.LOGIN_UTENTE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response loginUtente(Utente utente);
	
	
	
}
