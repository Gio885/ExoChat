package it.exolab.exochat.entitymanagerprovider;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.exolab.exochat.costanti.Costanti;

/*
 * @PersistenceUnit viene utilizzata per iniettare l'istanza di EntityManagerFactory, che a sua volta può essere utilizzata per 
 * creare manualmente istanze di EntityManager all'interno del codice. D'altra parte, 
 * @PersistenceContext viene utilizzata per iniettare direttamente un'istanza di EntityManager, 
 * semplificando l'utilizzo dell'EntityManager senza dover gestire manualmente l'EntityManagerFactory.
 */

public class EntityManagerProvider {

	protected static EntityManagerFactory entityManagerFactory;
	
	/*
	Blocco di inizializzazione statica:
	Questo blocco statico viene eseguito quando la classe viene caricata, generalmente al momento dell'avvio 
	dell'applicazione. Viene creata l'entitymanagerfactory tramite il nome dell'unita di persistenza definita
	nel persistence.xml
	Questa classe viene estesa da tutti i controller che vanno a prendere l'unica istanza della Factory che viene
	inizializzata tramite il blocco di inizializzazione statico con cui poi andiamo a stanziare l'entityManager
	*/
	 static {
		 entityManagerFactory = Persistence.createEntityManagerFactory(Costanti.PERSISTENCE_UNIT_NAME);
	    }
	 
	 public static EntityManager getEntityManager() {
		 return entityManagerFactory.createEntityManager();	 
	 }
	 
	 
	 
	 
	 /**
	  * Session Bean implementation class UtenteController
	  * 
	  * @PersistenceContext per inettare un istanza entity manager per operazioni di persistenza JTA
	  * 
	  * @PersistenceUnit per iniettare un istanza della factory per creare entitymanager per fare operazioni di persistenza RESOURCE LOCAL quindi MANUALI
	  */
	 
	 //LINEA UTENTE OK DA REST A CRUD
	 //LINEA CHIAMATA OK DA REST A CRUD
	 //LINEA UTENTEGRUPPO OK DA REST A CRUD
	 //LINEA CHAT OK DA REST A CRUD
	 //LINEA GRUPPO OK DA REST A CRUD
	 //LINEA MESSAGGIO
	 
	 
	 
	 

}
