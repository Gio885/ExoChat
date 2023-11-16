package it.exolab.exochat.controller;

import it.exolab.exochat.costanti.Costanti;
import it.exolab.exochat.crud.MessaggioCrud;
import it.exolab.exochat.dto.Dto;
import it.exolab.exochat.eccezioni.BusinessException;
import it.exolab.exochat.ejbinterface.MessaggioControllerInterface;
import it.exolab.exochat.model.Messaggio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 * Session Bean implementation class MessaggioController
 */
@Stateless(name = "MessaggioControllerInterface")
@LocalBean
public class MessaggioController implements MessaggioControllerInterface {

    
	@PersistenceUnit(name = Costanti.PERSISTENCE_UNIT_NAME)
	private EntityManagerFactory entityManagerFactory;
	
    public MessaggioController() {
    	
    }

	@Override
	public List<Messaggio> findMessaggioByUtenteId(Integer utenteId) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			MessaggioCrud messaggioCrud = new MessaggioCrud();
			List<Messaggio> listaMessaggi = messaggioCrud.findMessaggioByUtenteId(utenteId, entityManager);
			return listaMessaggi;
//			if(!listaMessaggi.isEmpty()) {
//				Dto <Messaggio> dtoListaMessaggiChat = listaMessaggiRaggruppatiPerChat(listaMessaggi);
//				return dtoListaMessaggiChat;	
//			}else {
//				throw new BusinessException("Non ci sono messaggi");
//			}					
		}catch(BusinessException e) {
			throw new BusinessException(e.getMessage());
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore findMessaggioByUtenteId --ControllerMessaggio--");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}finally {
			entityManager.close();
		}
	}

	@Override
	public List<Messaggio> findMessaggioByGroupId(Integer gruppoId) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			MessaggioCrud messaggioCrud = new MessaggioCrud();
			List<Messaggio> listaMessaggiGruppo = messaggioCrud.findMessaggioByGroupId(gruppoId, entityManager);
			return listaMessaggiGruppo;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore findMessaggioByGroupId --ControllerMessaggio--");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}finally {
			entityManager.close();
		}
	}

	@Override
	public void insertMessaggio(Messaggio messaggio) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			MessaggioCrud messaggioCrud = new MessaggioCrud();
			messaggioCrud.insertMessaggio(messaggio, entityManager);
			entityManager.getTransaction().commit();			
		}catch(Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			System.out.println("Errore insertMessaggio --ControllerMessaggio--");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}finally {
			entityManager.close();
		}
	}

	private Dto<Messaggio> listaMessaggiRaggruppatiPerChat (List<Messaggio> listaMessaggiUtente) {
		Dto<Messaggio> dtoMessaggiRaggruppatiPerChat = new Dto<Messaggio>();
        List<Object> chatConMessaggi = new ArrayList<>();
        Map<Integer, List<Messaggio>> messaggiPerChat = new HashMap<>();

        // Iteriamo sulla lista dei messaggi
        for (Messaggio messaggio : listaMessaggiUtente) {
            Integer idChat = messaggio.getChat().getIdChat(); // Assumendo che esista un metodo getId() sulla classe Chat

            // Controlla se l'ID chat è già nella mappa
            if (messaggiPerChat.containsKey(idChat)) {
                // Se l'ID chat è già presente, aggiungi il messaggio alla lista esistente
                messaggiPerChat.get(idChat).add(messaggio);
            } else {
                // Se l'ID chat non è presente, crea una nuova lista e aggiungi il messaggio
                List<Messaggio> nuovaListaMessaggi = new ArrayList<>();
                nuovaListaMessaggi.add(messaggio);
                messaggiPerChat.put(idChat, nuovaListaMessaggi);
            }
        }
        dtoMessaggiRaggruppatiPerChat.setData(chatConMessaggi);
        return dtoMessaggiRaggruppatiPerChat;
    }
	           	
}
