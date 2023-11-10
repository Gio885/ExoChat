package it.exolab.exochat.entitymanagerprovider;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * @PersistenceUnit viene utilizzata per iniettare l'istanza di EntityManagerFactory, che a sua volta può essere utilizzata per 
 * creare manualmente istanze di EntityManager all'interno del codice. D'altra parte, 
 * @PersistenceContext viene utilizzata per iniettare direttamente un'istanza di EntityManager, 
 * semplificando l'utilizzo dell'EntityManager senza dover gestire manualmente l'EntityManagerFactory.
 */

public class EntityManagerProvider {

	private static final String PERSISTENCE_UNIT_NAME = "PersistenceUnit";
	private static EntityManagerFactory entityManagerFactory;
	
	 static {
		 entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    }
	 
	 public static EntityManager getEntityManager() {
		 return entityManagerFactory.createEntityManager();	 
	 }

}
