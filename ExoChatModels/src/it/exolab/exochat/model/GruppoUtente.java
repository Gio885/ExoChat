package it.exolab.exochat.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "GRUPPO_UTENTE")
public class GruppoUtente implements Serializable{

	private static final long serialVersionUID = 2434305999037183370L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PARTECIPANTE")
    private Integer idPartecipante;
	
    @Column(name = "GRUPPO_ID", nullable = false)
	private Integer gruppoId;
    
    @Column(name = "UTENTE_ID", nullable = false)
	private Integer utenteId;

    @ManyToOne
    @JoinColumn(name = "GRUPPO_ID", insertable = false, updatable = false)
    private Gruppo gruppo;

    @ManyToOne
    @JoinColumn(name = "UTENTE_ID", insertable = false, updatable = false)
    private Utente utente;

	public Integer getIdPartecipante() {
		return idPartecipante;
	}

	public void setIdPartecipante(Integer idPartecipante) {
		this.idPartecipante = idPartecipante;
	}

	public Integer getGruppoId() {
		return gruppoId;
	}

	public void setGruppoId(Integer gruppoId) {
		this.gruppoId = gruppoId;
	}

	public Integer getUtenteId() {
		return utenteId;
	}

	public void setUtenteId(Integer utenteId) {
		this.utenteId = utenteId;
	}

	public Gruppo getGruppo() {
		return gruppo;
	}

	public void setGruppo(Gruppo gruppo) {
		this.gruppo = gruppo;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}
    
    
    
    
}
