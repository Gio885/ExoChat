package it.exolab.exochat.crud;

import javax.persistence.EntityManager;

import it.exolab.exochat.costanti.Costanti;

public class BaseCrud <T> {

	//public abstract T findById(Integer id,EntityManager entityManager) throws Exception;
	
	
	protected T findById(Integer id,Class<T> entityClass,EntityManager entityManager) throws Exception {
		try {
			return (T) entityManager.find(entityClass,id);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Errore nel metodo findById "+ entityClass+" della classe BaseCrud ---Exception---");
			throw new Exception(Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}
	}
	
	
	protected T insert(T oggetto,EntityManager entityManager) throws Exception{
		try {
			entityManager.persist(oggetto);
			entityManager.flush(); // SI ASSICURA CHE LE MODIFICHE VENGANO APPLICATE PRIMA DI OTTENERE L'ID
									// GENERATO
			return oggetto;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Errore nel metodo insert "+ oggetto.getClass() +" della classe BaseCrud ---Exception---");
			throw new Exception(Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}
	}
	
	protected T update(T oggetto,EntityManager entityManager) throws Exception{
		try {
			if (!entityManager.contains(oggetto)) {
				oggetto = entityManager.merge(oggetto);
			}
			entityManager.flush();
			return oggetto;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Errore nel metodo update "+ oggetto.getClass() +" della classe BaseCrud ---Exception---");
			throw new Exception(Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}
	}
	
	protected boolean delete(T oggetto,EntityManager entityManager) throws Exception{
		try {
			if (!entityManager.contains(oggetto)) {
				oggetto = entityManager.merge(oggetto);
			}
			entityManager.remove(oggetto);
			entityManager.flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Errore nel metodo delete "+ oggetto.getClass() +" della classe BaseCrud ---Exception---");
			throw new Exception(Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}
	}
	
	
}
