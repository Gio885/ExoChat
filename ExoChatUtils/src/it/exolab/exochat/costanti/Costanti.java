package it.exolab.exochat.costanti;

public class Costanti {

	public static final String PERSISTENCE_UNIT_NAME = "PersistenceUnit";
	public static final String ERRORE_CONTATTA_ASSISTENZA = "Si è verificato un errore, contatta l'assistenza";
	public static final String ERRORE_RICERCA_UTENTE = "C'è stato un errore nella ricerca dell'utente, contatta l'assistenza";
	public static final String ERRORE_CARICAMENTO_UTENTI = "C'è stato un errore nel caricamento degli utenti, contatta l'assistenza";
	public static final String REGEX_USERNAME = "^[a-zA-Z0-9_]{3,20}$";  
	public static final String REGEX_EMAIL = "^[A-Za-z0-9._%+-]{4,}@([A-Za-z0-9-]{4,}\\.)+[A-Za-z]{2,}$";
	public static final String REGEX_PASSWORD = "^(?=.[a-z])(?=.[A-Z])(?=.\\d)(?=.[@#$%^&!])[A-Za-z\\d@#$%^&!]+$";

}
