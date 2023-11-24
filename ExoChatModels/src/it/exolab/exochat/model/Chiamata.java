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
	
    @Column(name = "CHIAMANTE_ID", nullable = false,insertable = false, updatable = false)
	private Integer chiamanteId;
	
    @Column(name = "RICEVENTE_ID", insertable = false, updatable = false)
	private Integer riceventeId;
	
    @Column(name = "GRUPPO_RICEVENTE_ID", insertable = false, updatable = false)
	private Integer gruppoRiceventeId;
	
	@Column(name = "DATA_ORA_INIZIO")
    private Date dataOraInizio;

    @Column(name = "DATA_ORA_FINE")
    private Date dataOraFine;

    @Column(name = "DURATA")
    private Time durata;

    @ManyToOne
    @JoinColumn(name = "CHIAMANTE_ID", referencedColumnName = "ID_UTENTE")
    private Utente chiamante;

    @ManyToOne
    @JoinColumn(name = "RICEVENTE_ID", referencedColumnName = "ID_UTENTE")
    private Utente ricevente;

    @ManyToOne
    @JoinColumn(name = "GRUPPO_RICEVENTE_ID", referencedColumnName = "ID_GRUPPO")
    private Gruppo gruppoRicevente;
    
    
    

	@Override
	public int hashCode() {
		return Objects.hash(idChiamata);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chiamata other = (Chiamata) obj;
		return Objects.equals(idChiamata, other.idChiamata);
	}

	public Integer getIdChiamata() {
		return idChiamata;
	}

	public void setIdChiamata(Integer idChiamata) {
		this.idChiamata = idChiamata;
	}

	public Integer getChiamanteId() {
		return chiamanteId;
	}

	public void setChiamanteId(Integer chiamanteId) {
		this.chiamanteId = chiamanteId;
	}

	public Integer getRiceventeId() {
		return riceventeId;
	}

	public void setRiceventeId(Integer riceventeId) {
		this.riceventeId = riceventeId;
	}

	public Integer getGruppoRiceventeId() {
		return gruppoRiceventeId;
	}

	public void setGruppoRiceventeId(Integer gruppoRiceventeId) {
		this.gruppoRiceventeId = gruppoRiceventeId;
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

	
    
    
    
    
    
    
    
    
    

}
