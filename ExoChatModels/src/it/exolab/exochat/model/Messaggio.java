package it.exolab.exochat.model;

import java.io.Serializable;
import java.util.Date;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

@Entity
@Table(name = "MESSAGGIO")
public class Messaggio implements Serializable {

	private static final long serialVersionUID = -6494890555390690804L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_MESSAGGIO")
	private Integer idMessaggio;
	
	@Column(name = "MITTENTE_ID")
	private Integer mittenteId;
	
	@Column(name = "DESTINATARIO_ID")
	private Integer destinatarioId;
	
	@Column(name = "GRUPPO_ID")
	private Integer gruppoId;
	
	@Column(name = "CONTENUTO_MESSAGGIO", nullable = false)
	private String contenutoMessaggio;

	@Lob
	@Column(name = "FILE")
	private byte[] file;

	@Column(name = "DATA_ORA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Date dataOra;
	
	@Column(name = "CHAT_ID", nullable = false)
	private Integer chatId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MITTENTE_ID", insertable = false, updatable = false)
	private Utente mittente;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DESTINATARIO_ID", insertable = false, updatable = false)
	private Utente destinatario;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "GRUPPO_ID", insertable = false, updatable = false)
	private Gruppo gruppo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CHAT_ID", insertable = false, updatable = false)
	private Chat chat;

	public Integer getIdMessaggio() {
		return idMessaggio;
	}

	public void setIdMessaggio(Integer idMessaggio) {
		this.idMessaggio = idMessaggio;
	}

	public Integer getMittenteId() {
		return mittenteId;
	}

	public void setMittenteId(Integer mittenteId) {
		this.mittenteId = mittenteId;
	}

	public Integer getDestinatarioId() {
		return destinatarioId;
	}

	public void setDestinatarioId(Integer destinatarioId) {
		this.destinatarioId = destinatarioId;
	}

	public Integer getGruppoId() {
		return gruppoId;
	}

	public void setGruppoId(Integer gruppoId) {
		this.gruppoId = gruppoId;
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

	public Integer getChatId() {
		return chatId;
	}

	public void setChatId(Integer chatId) {
		this.chatId = chatId;
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

	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}
	
	
	
	
	
	
	
	

}
