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
import it.exolab.exochat.dto.Dto;
import it.exolab.exochat.dto.MessaggioDto;
import it.exolab.exochat.eccezioni.BusinessException;
import it.exolab.exochat.ejbinterface.MessaggioControllerInterface;
import it.exolab.exochat.endpoint.EndPoint;
import it.exolab.exochat.model.Chat;
import it.exolab.exochat.model.Messaggio;
import it.exolab.exochat.model.Utente;


@Path(EndPoint.MESSAGGIO_REST)
public class MessaggioRest {

	@POST
	@Path(EndPoint.INSERT_MESSAGGIO)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertMessage(MessaggioDto messaggio) {
		try {
			MessaggioControllerInterface messaggioService = new EjbService<MessaggioControllerInterface>(MessaggioControllerInterface.class).getEJB();
			messaggioService.insertMessaggio(messaggio);
			return Response.status(Status.OK).build();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore metodo insertMessaggio   ----MessaggioRest----");
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_DURANTE_INVIO_MESSAGGIO).build();
		}
	}
	
	//LISTA MESSAGGI DI UNA CHAT
	@POST
	@Path(EndPoint.LISTA_MESSAGGI_CHAT)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response findMessaggiForChatId(Chat chat) {
		try {
			MessaggioControllerInterface messaggioService = new EjbService<MessaggioControllerInterface>(MessaggioControllerInterface.class).getEJB();
			Dto<List<Messaggio>> listaMessaggiChat = messaggioService.findMessaggiForChatId(chat);
			return Response.status(Status.OK).entity(listaMessaggiChat.getData()).build();			
		}catch(BusinessException e) {
			return Response.status(Status.NO_CONTENT).entity(e.getMessage()).build();
		}catch(Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CARICAMENTO_MESSAGGI).build();
		}
	}
	
	//LISTA ULTIMI MESSAGGI DIVISI PER CHAT
	@POST
	@Path(EndPoint.LISTA_LAST_MESSAGGIO_CHAT)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response findLastMessaggeForChat(Utente utente) {
		try {
			MessaggioControllerInterface messaggioService = new EjbService<MessaggioControllerInterface>(MessaggioControllerInterface.class).getEJB();
			Dto<List<Messaggio>> ultimoMessaggioPerChat = messaggioService.findLastMessaggeForChat(utente);
			return Response.status(Status.OK).entity(ultimoMessaggioPerChat).build();			
		}catch(BusinessException e) {
			return Response.status(Status.NO_CONTENT).entity(e.getMessage()).build();
		}catch(Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CARICAMENTO_MESSAGGI).build();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	

//	@POST
//	@Path(EndPoint.LISTA_MESSAGGI_UTENTE)
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Response findAllMessageUtente(Utente utente) {
//		try {
//			MessaggioControllerInterface messaggioService = new EjbService<MessaggioControllerInterface>(MessaggioControllerInterface.class).getEJB();
//			List<Messaggio> listaMessaggiUtente = messaggioService.findMessaggioByUtenteId(utente.getIdUtente());
//			return Response.status(Status.OK).entity(listaMessaggiUtente).build();			
//		}catch(BusinessException e) {
//			return Response.status(Status.NO_CONTENT).entity(e.getMessage()).build();
//		}catch(Exception e) {
//			e.printStackTrace();
//			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CONTATTA_ASSISTENZA).build();
//		}
//	}
	
	
}
