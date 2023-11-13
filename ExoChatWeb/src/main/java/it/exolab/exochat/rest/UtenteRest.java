package it.exolab.exochat.rest;

import java.awt.PageAttributes.MediaType;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import it.exolab.exochat.conf.EjbService;
import it.exolab.exochat.ejbinterface.UtenteControllerInterface;
import it.exolab.exochat.model.Utente;

@Path(value = "/utenteRest")
public class UtenteRest {
	
	

	
	
	@POST

	public Response insertUtente(Utente utente) {
		try {
			UtenteControllerInterface utenteService = new EjbService<UtenteControllerInterface>(UtenteControllerInterface.class).getEJB();
			Utente utenteInserito = utenteService.insertUtente(utente);
			return Response.status(Status.OK).entity(utenteInserito).build();
		}catch(Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		
	}
	
	
}
