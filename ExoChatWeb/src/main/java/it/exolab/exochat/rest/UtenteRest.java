package it.exolab.exochat.rest;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import it.exolab.exochat.conf.EjbService;
import it.exolab.exochat.dto.Dto;
import it.exolab.exochat.eccezioni.BusinessException;
import it.exolab.exochat.ejbinterface.UtenteControllerInterface;
import it.exolab.exochat.endpoint.EndPoint;
import it.exolab.exochat.model.Utente;

@Path(value = EndPoint.UTENTE_REST)
public class UtenteRest {
	
	@POST
	@Path(EndPoint.INSERT_UTENTE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertUtente(Utente utente) {
		try {
			UtenteControllerInterface utenteService = new EjbService<UtenteControllerInterface>(UtenteControllerInterface.class).getEJB();
			Dto<Utente> utenteInserito = utenteService.insertUtente(utente);
			if(utenteInserito.isSuccess()) {
				return Response.status(Status.OK).entity(utenteInserito.getData()).build();
			}else {
				return Response.status(Status.NO_CONTENT).build();
			}
		}catch(BusinessException e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}catch(Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}		
	}
	
	@POST
	@Path(EndPoint.LOGIN_UTENTE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response loginUtente(Utente utente) {
		try {
			UtenteControllerInterface utenteService = new EjbService<UtenteControllerInterface>(UtenteControllerInterface.class).getEJB();
			Dto<Utente> dtoUtente = utenteService.findUtenteByEmailAndPassword(utente);
			if(dtoUtente.isSuccess()) {
				return Response.status(Status.OK).entity(dtoUtente.getData()).build();
			}else {
				return Response.status(Status.NO_CONTENT).build();
			}
		}catch(Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();		
		}
		
	}
	
	
	
	
}
