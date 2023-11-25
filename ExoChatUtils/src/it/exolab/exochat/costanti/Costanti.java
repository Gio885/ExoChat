package it.exolab.exochat.costanti;

public class Costanti {

	public static final String PERSISTENCE_UNIT_NAME = "PersistenceUnit";
	public static final String ERRORE_CONTATTA_ASSISTENZA = "Si è verificato un errore, contatta l'assistenza";
	public static final String ERRORE_RICERCA_UTENTE = "C'è stato un errore nella ricerca dell'utente, contatta l'assistenza";
	public static final String ERRORE_CARICAMENTO_UTENTI = "C'è stato un errore nel caricamento degli utenti, contatta l'assistenza";
	public static final String ERRORE_CARICAMENTO_MESSAGGI = "C'è stato un errore nel caricamento dei messaggi, contatta l'assistenza";
	public static final String ERRORE_CARICAMENTO_GRUPPI = "C'è stato un errore nel caricamento dei gruppi, contatta l'assistenza";
	public static final String ERRORE_CARICAMENTO_CHIAMATE = "C'è stato un errore nel caricamento delle chiamate, contatta l'assistenza";
	public static final String ERRORE_CARICAMENTO_CHAT = "C'è stato un errore nel caricamento delle chat, contatta l'assistenza";
	public static final String REGEX_USERNAME = "^[a-zA-Z0-9_]{3,20}$";  
	public static final String REGEX_EMAIL = "^[A-Za-z0-9._%+-]{4,}@([A-Za-z0-9-]{4,}\\.)+[A-Za-z]{2,}$";
	public static final String REGEX_PASSWORD = "^(?=.[a-z])(?=.[A-Z])(?=.\\d)(?=.[@#$%^&!])[A-Za-z\\d@#$%^&!]+$";
	public static final Integer TIPO_CHAT_SINGOLA = 1;
	public static final Integer TIPO_CHAT_GRUPPO = 2; 
	public static final String CREDENZIALI_ERRATE = "Credenziali errate";
	public static final String NON_CI_SONO_CONTATTI = "Non ci sono contatti";
	public static final String NON_CI_SONO_MESSAGGI = "Non ci sono messaggi";
	public static final String NON_CI_SONO_CHAT_NON_INIZIATE = "Non ci sono chat non iniziate";
	public static final String NON_CI_SONO_CHAT_INIZIATE = "Non ci sono chat iniziate";
	public static final String ERRORE_CREAZIONE_GRUPPO = "Si è verificato un errore durante la creazione del gruppo, contatta l'assistenza";
	public static final String ERRORE_INSERIMENTO_UTENTI_GRUPPO = "Si è verificato un errore durante la creazione del gruppo, contatta l'assistenza";
	public static final String ERRORE_DURANTE_INVIO_MESSAGGIO = "Si è verificato un errore durante l'invio del messaggio, contatta l'assistenza";
	public static final String ERRORE_VALIDAZIONE_USERNAME = "Inserisci un Username valido, l'username deve essere di lunghezza compresa tra 3 e 20 caratteri, puo contenere lettere (minuscolo e maiuscolo), numeri e il carattere speciale underscore";
	public static final String ERRORE_VALIDAZIONE_EMAIL ="Inserisci un Email valida, puo contentere lettere ( maiuscole e minuscole), numeri, caratteri speciali e deve avere una lunghezza compresa tra 8 e 30 caratteri";
	public static final String ERRORE_VALIDAZIONE_PASSWORD ="Inserisci una Password valida, deve contenere almeno un carattere maiuscolo, un carattere minuscolo, un carattere speciale e deve avere una lunghezza compresa tra 8 e 20 caratteri";

}
