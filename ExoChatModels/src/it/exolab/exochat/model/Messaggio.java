package it.exolab.exochat.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "MESSAGGIO")
public class Messaggio implements Serializable {

	private static final long serialVersionUID = -6494890555390690804L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_MESSAGGIO")
	private Integer idMessaggio;

	@ManyToOne
	@JoinColumn(name = "MITTENTE_ID", nullable = false)
	private Utente mittente;

	@ManyToOne
	@JoinColumn(name = "DESTINATARIO_ID")
	private Utente destinatario;

	@ManyToOne
	@JoinColumn(name = "GRUPPO_ID")
	private Gruppo gruppo;

	@Column(name = "CONTENUTO_MESSAGGIO", nullable = false)
	private String contenutoMessaggio;

	@Lob
	@Column(name = "FILE")
	private byte[] file;

	@Column(name = "DATA_ORA", nullable = false)
	private Date dataOra;

	@ManyToOne
	@JoinColumn(name = "CHAT_ID", nullable = false)
	private Chat chat;
	
	
	
	
	
	

	public Integer getIdMessaggio() {
		return idMessaggio;
	}

	public void setIdMessaggio(Integer idMessaggio) {
		this.idMessaggio = idMessaggio;
	}

	public Utente getMittente() {
		return mittente;
	}

	public void setMittente(Utente mittente) {
		this.mittente = mittente;
	}

	public Utente getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Utente destinatario) {
		this.destinatario = destinatario;
	}

	public Gruppo getGruppo() {
		return gruppo;
	}

	public void setGruppo(Gruppo gruppo) {
		this.gruppo = gruppo;
	}

	public String getContenutoMessaggio() {
		return contenutoMessaggio;
	}

	public void setContenutoMessaggio(String contenutoMessaggio) {
		this.contenutoMessaggio = contenutoMessaggio;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public Date getDataOra() {
		return dataOra;
	}

	public void setDataOra(Date dataOra) {
		this.dataOra = dataOra;
	}

	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

}
