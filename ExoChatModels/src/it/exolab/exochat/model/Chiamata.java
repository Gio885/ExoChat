package it.exolab.exochat.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Chiamata implements Serializable {

	private static final long serialVersionUID = -8763645496435630199L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CHIAMATA")
    private int idChiamata;

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
    private java.sql.Timestamp dataOraInizio;

    @Column(name = "DATA_ORA_FINE")
    private java.sql.Timestamp dataOraFine;

    @Column(name = "DURATA", nullable = false)
    private java.sql.Time durata;

	public int getIdChiamata() {
		return idChiamata;
	}

	public void setIdChiamata(int idChiamata) {
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

	public java.sql.Timestamp getDataOraInizio() {
		return dataOraInizio;
	}

	public void setDataOraInizio(java.sql.Timestamp dataOraInizio) {
		this.dataOraInizio = dataOraInizio;
	}

	public java.sql.Timestamp getDataOraFine() {
		return dataOraFine;
	}

	public void setDataOraFine(java.sql.Timestamp dataOraFine) {
		this.dataOraFine = dataOraFine;
	}

	public java.sql.Time getDurata() {
		return durata;
	}

	public void setDurata(java.sql.Time durata) {
		this.durata = durata;
	}
    
    

}
