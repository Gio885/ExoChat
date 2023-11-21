package it.exolab.exochat.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

@Entity
@Table(name = "UTENTE")
public class Utente implements Serializable {

	private static final long serialVersionUID = 4320540258352296073L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_UTENTE")
	private Integer idUtente;

	@Column(name = "USERNAME", nullable = false)
	private String username;

	@Column(name = "EMAIL", nullable = false, unique = true)
	private String email;

	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@Column(name = "INFO")
	private String info;

	@Lob
	@Column(name = "FOTO")
	private byte[] foto;
	
	@Transient
	private String fotoConvertita;

	@JsonbTransient
	@OneToMany(mappedBy = "mittente",fetch = FetchType.LAZY)
	private List<Messaggio> messaggiMittente;
	
	@JsonbTransient
	@OneToMany(mappedBy = "destinatario",fetch = FetchType.LAZY)
	private List<Messaggio> messaggiDestinatario;
	
	@JsonbTransient
	@OneToMany(mappedBy = "amministratore",fetch = FetchType.LAZY)
	private List<Gruppo> amministratoreGruppi;
	
	@JsonbTransient
	@OneToMany(mappedBy = "chiamante",fetch = FetchType.LAZY)
	private List<Chiamata> chiamateEffettuate;
	
	@JsonbTransient
	@OneToMany(mappedBy = "ricevente",fetch = FetchType.LAZY)
	private List<Chiamata> chiamateRicevute;

	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(email, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utente other = (Utente) obj;
		return Objects.equals(email, other.email) && Objects.equals(password, other.password);
	}

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

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getFotoConvertita() {
		return fotoConvertita;
	}

	public void setFotoConvertita(String fotoConvertita) {
		this.fotoConvertita = fotoConvertita;
	}

	public List<Messaggio> getMessaggiMittente() {
		return messaggiMittente;
	}

	public void setMessaggiMittente(List<Messaggio> messaggiMittente) {
		this.messaggiMittente = messaggiMittente;
	}

	public List<Messaggio> getMessaggiDestinatario() {
		return messaggiDestinatario;
	}

	public void setMessaggiDestinatario(List<Messaggio> messaggiDestinatario) {
		this.messaggiDestinatario = messaggiDestinatario;
	}

	public List<Gruppo> getAmministratoreGruppi() {
		return amministratoreGruppi;
	}

	public void setAmministratoreGruppi(List<Gruppo> amministratoreGruppi) {
		this.amministratoreGruppi = amministratoreGruppi;
	}

	public List<Chiamata> getChiamateEffettuate() {
		return chiamateEffettuate;
	}

	public void setChiamateEffettuate(List<Chiamata> chiamateEffettuate) {
		this.chiamateEffettuate = chiamateEffettuate;
	}

	public List<Chiamata> getChiamateRicevute() {
		return chiamateRicevute;
	}

	public void setChiamateRicevute(List<Chiamata> chiamateRicevute) {
		this.chiamateRicevute = chiamateRicevute;
	}

	
	
	
	

	


}
