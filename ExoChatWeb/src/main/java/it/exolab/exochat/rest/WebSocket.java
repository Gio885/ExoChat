package it.exolab.exochat.rest;

import java.util.List;
import java.util.Objects;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import it.exolab.exochat.costanti.Costanti;
import it.exolab.exochat.dto.MessaggioDto;
import it.exolab.exochat.ejbinterface.MessaggioControllerInterface;



@ServerEndpoint("/webSocket/{idChat}")
@ApplicationScoped
public class WebSocket {

	@Inject
	private GestoreSessioni gestoreSessioni;
	
	@EJB
	private MessaggioControllerInterface messaggioEjbInterface;
	
	
	@OnOpen
	public void open(Session session,@PathParam("idChat")String idChatDaAssociareAdUnaSessione) throws Exception {
			Integer idChat = Integer.valueOf(idChatDaAssociareAdUnaSessione);
			System.out.println(session.getId()+"  --------id sessione");
			System.out.println(session.getRequestURI()+"  --------URI sessione");
			gestoreSessioni.inserisciSessione(idChat, session);	
		
		
	}
	
	@OnError
    public void onError(Throwable error) {
	
	}
	
	@OnMessage
	public void message(String message,Session session,@PathParam("idChat")String idChat) throws Exception {
		try {
			Jsonb jsonb = JsonbBuilder.create();
			MessaggioDto messaggio = jsonb.fromJson(message, MessaggioDto.class);
			messaggioEjbInterface.insertMessaggio(messaggio);
			Integer id = Integer.valueOf(idChat);
			List<Session> sessioniDaTrovare = gestoreSessioni.trovaSessioniAssociate(id);
			for(Session sessione : sessioniDaTrovare) {
				System.out.println("messaggio mandato a "+sessione);
			    sessione.getAsyncRemote().sendText(message);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore metodo WebSocket OnMessage -----");
			throw new Exception(Objects.nonNull(e)?e.getMessage():Costanti.ERRORE_DURANTE_INVIO_MESSAGGIO);
		}
		
	}
	
	@OnClose
	public void close(Session session,@PathParam("idChat")String idChat) {
		Integer id = Integer.valueOf(idChat);
		gestoreSessioni.rimuoviSessione(id, session);
		System.out.println("Connessione chiusa chat: "+id+" sessione: "+session.getId());
	}
	
}
