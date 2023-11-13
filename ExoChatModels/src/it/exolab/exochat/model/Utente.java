package it.exolab.exochat.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "UTENTE")
public class Utente implements Serializable {

	private static final long serialVersionUID = 4320540258352296073L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_UTENTE")
	private int idUtente;

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

	
	
	
	
	
	
	
	public int getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(int idUtente) {
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

}
