package it.exolab.exochat.dto;

import java.util.Date;

public class MessaggioDto {
	
	
	private Integer idMessaggio;
	private AccountDto mittente;
	private AccountDto destinatario;
	private AccountDto gruppo;
	private String contenutoMessaggio;
	private Date dataOra;
	private Integer idChat;
	private Integer tipoChatId;
	
	
	
	public Integer getIdMessaggio() {
		return idMessaggio;
	}
	public void setIdMessaggio(Integer idMessaggio) {
		this.idMessaggio = idMessaggio;
	}
	public AccountDto getMittente() {
		return mittente;
	}
	public void setMittente(AccountDto mittente) {
		this.mittente = mittente;
	}
	public AccountDto getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(AccountDto destinatario) {
		this.destinatario = destinatario;
	}
	public AccountDto getGruppo() {
		return gruppo;
	}
	public void setGruppo(AccountDto gruppo) {
		this.gruppo = gruppo;
	}
	public String getContenutoMessaggio() {
		return contenutoMessaggio;
	}
	public void setContenutoMessaggio(String contenutoMessaggio) {
		this.contenutoMessaggio = contenutoMessaggio;
	}
	public Date getDataOra() {
		return dataOra;
	}
	public void setDataOra(Date dataOra) {
		this.dataOra = dataOra;
	}
	public Integer getIdChat() {
		return idChat;
	}
	public void setIdChat(Integer idChat) {
		this.idChat = idChat;
	}
	public Integer getTipoChatId() {
		return tipoChatId;
	}
	public void setTipoChatId(Integer tipoChatId) {
		this.tipoChatId = tipoChatId;
	}

	
	

}
