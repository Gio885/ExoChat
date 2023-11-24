package it.exolab.exochat.controller;

import it.exolab.exochat.convertitore.Convertitore;
import it.exolab.exochat.costanti.Costanti;
import it.exolab.exochat.crud.GruppoCrud;
import it.exolab.exochat.crud.UtenteCrud;
import it.exolab.exochat.dto.AccountDto;
import it.exolab.exochat.dto.Dto;
import it.exolab.exochat.ejbinterface.GruppoControllerInterface;
import it.exolab.exochat.entitymanagerprovider.EntityManagerProvider;
import it.exolab.exochat.model.Gruppo;
import it.exolab.exochat.model.Utente;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 * Session Bean implementation class GruppoController
 */
@Stateless(name = "GruppoControllerInterface")
@LocalBean
public class GruppoController extends EntityManagerProvider implements GruppoControllerInterface {

    
	
    public GruppoController() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Gruppo> findAllGruppoByUtenteId(Integer utenteId) throws Exception {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		try {
			GruppoCrud gruppoCrud = new GruppoCrud();
			List<Gruppo> listaGruppiUtente = gruppoCrud.findAllGruppoByUtenteId(utenteId, entityManager);
			return listaGruppiUtente;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore metodo findAllGruppoByUtenteId ---GruppoController--- ");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CARICAMENTO_GRUPPI);
		}finally {
			entityManager.clear();
			entityManager.close();
		}
	}
	
	@Override
	public Dto<List<Gruppo>> findAllChatGruppoNonIniziate(Utente utente) throws Exception {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		try {
			GruppoCrud gruppoCrud = new GruppoCrud();
			Dto<List<Gruppo>> gruppoDto = new Dto<List<Gruppo>>();
			List<Gruppo> listaGruppiChatNonIniziate = gruppoCrud.findAllChatGruppoNonIniziate(utente, entityManager);
			List<AccountDto> listaGruppiConvertita = new Convertitore().convertListaGruppoToDto(listaGruppiChatNonIniziate);
			gruppoDto.setData(listaGruppiConvertita);
			return gruppoDto;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore metodo findAllChatGruppoNonIniziate ---GruppoController--- ");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}finally {
			entityManager.clear();
			entityManager.close();
		}
	}

	@Override
	public Dto<Gruppo> insertGruppo(Gruppo gruppo) throws Exception {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		try {
			Dto<Gruppo> gruppoDto = new Dto<Gruppo>();
			GruppoCrud gruppoCrud = new GruppoCrud();
			UtenteCrud utenteCrud = new UtenteCrud();
			entityManager.getTransaction().begin();
			Utente utenteDaTrovare = utenteCrud.findUtenteById(gruppo.getAmministratoreGruppo(), entityManager);
			buildGruppo(gruppo,utenteDaTrovare);			
			Gruppo gruppoInserito = gruppoCrud.insertGruppo(gruppo, entityManager);
			entityManager.getTransaction().commit();
			gruppoDto.setData(new Convertitore().convertGruppoToDto(gruppoInserito));
			return gruppoDto;
		}catch(Exception e) {
			e.printStackTrace();
			entityManager.close();
			System.out.println("Errore metodo insertGruppo ---GruppoController--- ");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}finally {
			entityManager.clear();
			entityManager.close();
		}
	}

	@Override
	public Gruppo updateGruppo(Gruppo gruppo) throws Exception {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		try {
			GruppoCrud gruppoCrud = new GruppoCrud();
			entityManager.getTransaction().begin();
			Gruppo gruppoAggiornato = gruppoCrud.updateGruppo(gruppo, entityManager);
			entityManager.getTransaction().commit();
			return gruppoAggiornato;
		}catch(Exception e) {
			e.printStackTrace();
			entityManager.close();
			System.out.println("Errore metodo updateGruppo ---GruppoController--- ");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}finally {
			entityManager.clear();
			entityManager.close();
		}		
	}

	@Override
	public void deleteGruppo(Gruppo gruppo) throws Exception {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		try {
			GruppoCrud gruppoCrud = new GruppoCrud();
			entityManager.getTransaction().begin();
			gruppoCrud.deleteGruppo(gruppo, entityManager);
			entityManager.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			entityManager.close();
			System.out.println("Errore metodo updateGruppo ---GruppoController--- ");
			throw new Exception(null != e.getMessage() ? e.getMessage() : Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}finally {
			entityManager.clear();
			entityManager.close();
		}
		
	}
	
	private void buildGruppo(Gruppo gruppo,Utente amministratore) throws IOException {
		try {
			if(null == gruppo.getInfoGruppo()) {
				gruppo.setInfoGruppo("Disponibile");
			}
			if(null == gruppo.getFotoGruppo()) {
				String imagePath = "fotoprofilogruppo.png";			
				ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
				InputStream inputStream = classLoader.getResourceAsStream(imagePath);
				if (inputStream != null) {
				    // Leggi l'immagine dall'input stream e convertila in un array di byte
				    byte[] imageBytes = inputStream.readAllBytes();

				    // Imposta l'array di byte nella proprietà 'foto' dell'utente
				    gruppo.setFotoGruppo(imageBytes);		    
				    inputStream.close();
				}	
			}
			gruppo.setAmministratore(amministratore);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Errore metodo setFotoUtente  ----UtenteController----");
            throw new IOException(Costanti.ERRORE_CONTATTA_ASSISTENZA);
        }
	}

	

}
