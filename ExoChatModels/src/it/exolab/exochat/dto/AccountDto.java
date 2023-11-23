package it.exolab.exochat.dto;

public class AccountDto {

	
	//DTO PER UTENTE E GRUPPO
	private Integer idUtente;
	private String username;
	private String email;
	private String password;
	private String info;
	private String fotoConvertita;
	private AccountDto amministratoreGruppo;
	

	public Integer getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(Integer idUtente) {
		this.idUtente = idUtente;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getFotoConvertita() {
		return fotoConvertita;
	}
	public void setFotoConvertita(String fotoConvertita) {
		this.fotoConvertita = fotoConvertita;
	}
	public AccountDto getAmministratoreGruppo() {
		return amministratoreGruppo;
	}
	public void setAmministratoreGruppo(AccountDto amministratoreGruppo) {
		this.amministratoreGruppo = amministratoreGruppo;
	}
	
	
	
	
	
}
