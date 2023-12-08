package it.exolab.exochat.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.websocket.Session;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import it.exolab.exochat.model.Utente;

@Named
@ApplicationScoped
@Path("/session")
public class GestoreSessioni {

	private HashMap<Integer, List<Session>> listaSessioni;

	public GestoreSessioni() {
		listaSessioni = new HashMap<>();
	}

	public boolean controlloSessioneSuIdChat(Integer id, Session session) {
		return (listaSessioni.containsKey(id)) ? true : false;
	}

	public void inserisciSessione(Integer id, Session session) {
		if (listaSessioni.containsKey(id)) {
			List<Session> listaSessioniAssociate = listaSessioni.get(id);
			for (Session sessioneEsistente : listaSessioniAssociate) {
				if (!sessioneEsistente.equals(session)) {
					listaSessioniAssociate.add(session);
					System.out.println("aggiunta sessione");
				}
			}
		} else {
			List<Session> listaSessioniDaAssociare = new ArrayList<Session>();
			listaSessioniDaAssociare.add(session);
			listaSessioni.put(id, listaSessioniDaAssociare);
			System.out.println("Nuova chiave" + listaSessioni.size());
		}
	}

	public List<Session> trovaSessioniAssociate(Integer id) {
		return listaSessioni.get(id);
	}

	public void rimuoviSessione(Integer id, Session session) {
		List<Session> listaSessioniAssociate = listaSessioni.get(id);
		for (Session sessione : listaSessioniAssociate) {
			if (sessione.equals(session)) {
				listaSessioniAssociate.remove(sessione);
				System.out.println("SMONTAGGIO RIMOZIONE SESSIONE " + sessione);
				System.out.println(listaSessioniAssociate.contains(sessione));
			}
		}
		if (listaSessioniAssociate.isEmpty()) {
			listaSessioni.remove(id);
			System.out.println("RIMOZIONE COPPIA K-V CHAT: " + id);
		}
		System.out.println("RIMOZIONE SESSIONE CHAT: " + id + " DIMENSIONE HASHMAP " + listaSessioni.size());
	}

	public void stampaSessioniAperte() {
		// LAMBDA EXPRESSION
		listaSessioni.forEach((key, value) -> {
			System.out.println("Chiave: " + key + " valore: " + value);
		});
	}

//    public Set<Session> getSessioniByIdChat(Integer idChat) {
//        Set<Session> sessioniByIdChat = new HashSet<>();
//
//        for (Entry<Integer, Session> entry : listaSessioni.entrySet()) {
//            if (entry.getValue() == idChat) {
//                sessioniByIdChat.add(entry.getKey());
//            }
//        }
//        return sessioniByIdChat;
//    }

}
