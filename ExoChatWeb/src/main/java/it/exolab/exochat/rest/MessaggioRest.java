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
import it.exolab.exochat.dto.Dto;
import it.exolab.exochat.eccezioni.BusinessException;
import it.exolab.exochat.ejbinterface.MessaggioControllerInterface;
import it.exolab.exochat.endpoint.EndPoint;
import it.exolab.exochat.model.Messaggio;
import it.exolab.exochat.model.Utente;


@Path(value = EndPoint.MESSAGGIO_REST)
public class MessaggioRest {

	@POST
	@Path(EndPoint.LISTA_MESSAGGI_UTENTE)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response findAllMessaggeUtente(Utente utente) {
		try {
			MessaggioControllerInterface messaggioService = new EjbService<MessaggioControllerInterface>(MessaggioControllerInterface.class).getEJB();
			List<Messaggio> listaMessaggiUtente = messaggioService.findMessaggioByUtenteId(utente.getIdUtente());
			return Response.status(Status.OK).entity(listaMessaggiUtente).build();			
		}catch(BusinessException e) {
			return Response.status(Status.NO_CONTENT).entity(e.getMessage()).build();
		}catch(Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}
	
	@POST
	@Path(EndPoint.LISTA_LAST_MESSAGGIO_CHAT)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response findLastMessaggeForChat(Utente utente) {
		try {
			MessaggioControllerInterface messaggioService = new EjbService<MessaggioControllerInterface>(MessaggioControllerInterface.class).getEJB();
			List<Messaggio> ultimoMessaggioPerChat = messaggioService.findLastMessaggeForChat(utente);
			return Response.status(Status.OK).entity(ultimoMessaggioPerChat).build();			
		}catch(BusinessException e) {
			return Response.status(Status.NO_CONTENT).entity(e.getMessage()).build();
		}catch(Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}
	
	
}
