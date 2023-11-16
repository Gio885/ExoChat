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

    @ManyToOne
    @JoinColumn(name = "GRUPPO_ID", nullable = false)
    private Gruppo gruppo;

    @ManyToOne
    @JoinColumn(name = "UTENTE_ID", nullable = false)
    private Utente utente;
    
    
    
    
    
    

	public Integer getIdPartecipante() {
		return idPartecipante;
	}

	public void setIdPartecipante(Integer idPartecipante) {
		this.idPartecipante = idPartecipante;
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
