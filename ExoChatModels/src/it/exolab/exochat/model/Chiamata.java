package it.exolab.exochat.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "CHIAMATA")
public class Chiamata implements Serializable {

	private static final long serialVersionUID = -8763645496435630199L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CHIAMATA")
    private Integer idChiamata;

    @ManyToOne
    @JoinColumn(name = "CHIAMANTE_ID", nullable = false)
    private Utente chiamante;

    @ManyToOne
    @JoinColumn(name = "RICEVENTE_ID")
    private Utente ricevente;

    @ManyToOne
    @JoinColumn(name = "GRUPPO_RICEVENTE_ID")
    private Gruppo gruppoRicevente;

    @Column(name = "DATA_ORA_INZIO", nullable = false)
    private Date dataOraInizio;

    @Column(name = "DATA_ORA_FINE")
    private Date dataOraFine;

    @Column(name = "DURATA", nullable = false)
    private Time durata;
    
    
    
    
    
    
    
    

	public Integer getIdChiamata() {
		return idChiamata;
	}

	public void setIdChiamata(Integer idChiamata) {
		this.idChiamata = idChiamata;
	}

	public Utente getChiamante() {
		return chiamante;
	}

	public void setChiamante(Utente chiamante) {
		this.chiamante = chiamante;
	}

	public Utente getRicevente() {
		return ricevente;
	}

	public void setRicevente(Utente ricevente) {
		this.ricevente = ricevente;
	}

	public Gruppo getGruppoRicevente() {
		return gruppoRicevente;
	}

	public void setGruppoRicevente(Gruppo gruppoRicevente) {
		this.gruppoRicevente = gruppoRicevente;
	}

	public Date getDataOraInizio() {
		return dataOraInizio;
	}

	public void setDataOraInizio(Date dataOraInizio) {
		this.dataOraInizio = dataOraInizio;
	}

	public Date getDataOraFine() {
		return dataOraFine;
	}

	public void setDataOraFine(Date dataOraFine) {
		this.dataOraFine = dataOraFine;
	}

	public Time getDurata() {
		return durata;
	}

	public void setDurata(Time durata) {
		this.durata = durata;
	}
    
    

}
