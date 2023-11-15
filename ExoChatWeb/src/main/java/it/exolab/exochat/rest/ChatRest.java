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
import it.exolab.exochat.eccezioni.BusinessException;
import it.exolab.exochat.ejbinterface.ChatControllerInterface;
import it.exolab.exochat.endpoint.EndPoint;
import it.exolab.exochat.model.Chat;
import it.exolab.exochat.model.Utente;

@Path(value = EndPoint.CHAT_REST)
public class ChatRest {

	@POST
	@Path(EndPoint.LISTA_CHAT_UTENTE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response findChatForUtente(Utente utente) {
		try {
			ChatControllerInterface serviceChat = new EjbService<ChatControllerInterface>(ChatControllerInterface.class).getEJB();
			List<Chat> listaChatUtente = serviceChat.findAllChatByUtenteId(utente.getIdUtente());
			return Response.status(Status.OK).entity(listaChatUtente).build();
		} catch (BusinessException e) {
			e.printStackTrace();
			return Response.status(Status.NO_CONTENT).entity(e.getMessage()).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

}
