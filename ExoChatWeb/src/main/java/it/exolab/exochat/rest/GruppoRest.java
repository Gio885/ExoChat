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
import it.exolab.exochat.dto.AccountDto;
import it.exolab.exochat.dto.Dto;
import it.exolab.exochat.ejbinterface.GruppoControllerInterface;
import it.exolab.exochat.endpoint.EndPoint;
import it.exolab.exochat.model.Gruppo;
import it.exolab.exochat.model.Utente;

@Path(EndPoint.GRUPPO_REST)
public class GruppoRest {

	@POST
	@Path(EndPoint.INSERT_GRUPPO)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertGruppo(AccountDto gruppo) {
		try {
			GruppoControllerInterface gruppoService = new EjbService<GruppoControllerInterface>(GruppoControllerInterface.class).getEJB();
			Dto<Gruppo> gruppoInserito = gruppoService.insertGruppo(gruppo);
			return Response.status(Status.OK).entity(gruppoInserito.getData()).build();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore metodo insertGruppo ----GruppoRest----");
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CREAZIONE_GRUPPO).build();
		}			
	}
	
	@POST
	@Path(EndPoint.FIND_ALL_CHAT_GRUPPO_NON_INIZIATE)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response findAllChatGruppoNonIniziate(Utente utente) {
		try {
			GruppoControllerInterface gruppoService = new EjbService<GruppoControllerInterface>(GruppoControllerInterface.class).getEJB();
			Dto<List<Gruppo>> listaChatGruppoNonIniziate = gruppoService.findAllChatGruppoNonIniziate(utente);
			return Response.status(Status.OK).entity(listaChatGruppoNonIniziate.getData()).build();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore metodo findAllChatGruppoNonIniziate ----GruppoRest----");
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CARICAMENTO_CHAT).build();
		}
	}
	
}
