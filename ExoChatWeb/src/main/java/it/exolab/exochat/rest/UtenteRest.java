package it.exolab.exochat.rest;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import it.exolab.exochat.conf.EjbService;
import it.exolab.exochat.costanti.Costanti;
import it.exolab.exochat.dto.Dto;
import it.exolab.exochat.eccezioni.BusinessException;
import it.exolab.exochat.ejbinterface.UtenteControllerInterface;
import it.exolab.exochat.endpoint.EndPoint;
import it.exolab.exochat.model.Utente;

@Path(EndPoint.UTENTE_REST)
public class UtenteRest {
	
	@POST
	@Path(EndPoint.INSERT_UTENTE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertUtente(Utente utente) {
		try {
			UtenteControllerInterface utenteService = new EjbService<UtenteControllerInterface>(UtenteControllerInterface.class).getEJB();
			Dto<Utente> utenteInserito = utenteService.insertUtente(utente);
			return Response.status(Status.OK).entity(utenteInserito.getData()).build();		
		}catch(BusinessException e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore metodo insertUtente ---ChatRest---- ");
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CONTATTA_ASSISTENZA).build();
		}		
	}
	
	
	@POST
	@Path(EndPoint.INSERT_UTENTE)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUtente(Utente utente) {
		try {
			UtenteControllerInterface utenteService = new EjbService<UtenteControllerInterface>(UtenteControllerInterface.class).getEJB();
			Dto<Utente> utenteInserito = utenteService.insertUtente(utente);
			return Response.status(Status.OK).entity(utenteInserito.getData()).build();		
		}catch(BusinessException e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore metodo insertUtente ---ChatRest---- ");
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CONTATTA_ASSISTENZA).build();
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
			return Response.status(Status.OK).entity(dtoUtente.getData()).build();
		}catch(BusinessException e) {
			return Response.status(Status.NO_CONTENT).entity(e.getMessage()).build();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore metodo loginUtente ---UtenteRest---- ");
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CONTATTA_ASSISTENZA).build();		
		}
		
	}
	
	@GET
	@Path(EndPoint.FIND_ALL_UTENTE)
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllUtente() {
		try {
			UtenteControllerInterface utenteService = new EjbService<UtenteControllerInterface>(UtenteControllerInterface.class).getEJB();
			Dto<List<Utente>> dtoUtente = utenteService.findAllUtenti();
			return Response.status(Status.OK).entity(dtoUtente.getData()).build();
		}catch(BusinessException e) {
			e.printStackTrace();
			return Response.status(Status.NO_CONTENT).entity(e.getMessage()).build();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore metodo findAllUtente ---UtenteRest----");
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CONTATTA_ASSISTENZA).build();		
		}
	}
	
	@POST
	@Path(EndPoint.FIND_ALL_CHAT_NON_INIZIATE)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response findAllUtentiChatNonIniziate(Utente utente) {
		try {
			UtenteControllerInterface utenteService = new EjbService<UtenteControllerInterface>(UtenteControllerInterface.class).getEJB();
			Dto<List<Utente>> dtoUtente = utenteService.findAllUtentiChatNonIniziate(utente);
			return Response.status(Status.OK).entity(dtoUtente.getData()).build();
		}catch(BusinessException e) {
			e.printStackTrace();
			return Response.status(Status.NO_CONTENT).entity(e.getMessage()).build();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore metodo findAllUtente ---UtenteRest----");
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CONTATTA_ASSISTENZA).build();		
		}
	}
	
	
	
}
