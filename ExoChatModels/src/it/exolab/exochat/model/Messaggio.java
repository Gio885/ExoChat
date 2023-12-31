package it.exolab.exochat.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MESSAGGIO")
public class Messaggio implements Serializable {

	private static final long serialVersionUID = -6494890555390690804L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_MESSAGGIO")
	private Integer idMessaggio;
	
	@Column(name = "MITTENTE_ID", insertable = false, updatable = false)
	private Integer mittenteId;
	
	@Column(name = "DESTINATARIO_ID", insertable = false, updatable = false)
	private Integer destinatarioId;
	
	@Column(name = "GRUPPO_ID", insertable = false, updatable = false)
	private Integer gruppoId;
	
	@Column(name = "CONTENUTO_MESSAGGIO", nullable = false)
	private String contenutoMessaggio;

	@Lob
	@Column(name = "FILE")
	private byte[] file;

	@Column(name = "DATA_ORA")
	private Date dataOra;
	
	@Column(name = "CHAT_ID", nullable = false, insertable = false, updatable = false)
	private Integer chatId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MITTENTE_ID", referencedColumnName = "ID_UTENTE")
	private Utente mittente;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DESTINATARIO_ID", referencedColumnName = "ID_UTENTE")
	private Utente destinatario;

	@ManyToOne(fetch = FetchType.EAGER)   //IL CASCADE PERSIST PERMETTE DI PROPAGARE L'OPERAZIONE
	@JoinColumn(name = "GRUPPO_ID", referencedColumnName = "ID_GRUPPO")   // DI PERSISTENZA QUANDO SI SALVA IL MESSAGGIO
	private Gruppo gruppo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CHAT_ID" , referencedColumnName = "ID_CHAT")
	private Chat chat;
	

	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    Messaggio other = (Messaggio) obj;

	    // Check if destinatarioId is null
	    if (destinatarioId == null) {
	        // If destinatarioId is null, check gruppoId
	        return Objects.equals(gruppoId, other.gruppoId) &&
	               Objects.equals(dataOra, other.dataOra) &&
	               Objects.equals(mittenteId, other.mittenteId);
	    }

	    // If destinatarioId is not null, perform standard equality check
	    return Objects.equals(dataOra, other.dataOra) &&
	           Objects.equals(destinatarioId, other.destinatarioId) &&
	           Objects.equals(gruppoId, other.gruppoId) &&
	           Objects.equals(mittenteId, other.mittenteId);
	}
	
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
