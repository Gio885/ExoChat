package it.exolab.exochat.eccezioni;

public class BusinessException extends Exception {

	private static final long serialVersionUID = 4423441599525405943L;

	
	private String errore;
	
	
	public BusinessException (String errore) {
		super(errore);
	}

}
