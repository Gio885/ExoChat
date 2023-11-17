package it.exolab.exochat.model;

import java.io.Serializable;
import java.util.List;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

@Entity
@Table(name = "GRUPPO")
public class Gruppo implements Serializable {

	private static final long serialVersionUID = -3923397912562921521L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_GRUPPO")
    private Integer idGruppo;

    @Column(name = "NOME_GRUPPO", nullable = false)
    private String nomeGruppo;

    @Column(name = "INFO_GRUPPO")
    private String infoGruppo;

    @Lob
    @Column(name = "FOTO_GRUPPO")
    private byte[] fotoGruppo;
    
    @Column(name = "AMMINISTRATORE_GRUPPO")
    private Integer amministratoreGruppo;

    @ManyToOne
    @JoinColumn(name = "ID_UTENTE", insertable = false, updatable = false)
    private Utente amministratore;
    
    @JsonbTransient
    @OneToMany(mappedBy = "gruppo",fetch = FetchType.LAZY)
    private List<Messaggio> listaMessaggiGruppo;
    
    @JsonbTransient
    @OneToMany(mappedBy = "gruppoRicevente",fetch = FetchType.LAZY)
    private List<Chiamata> chiamateGruppo;

	public Integer getIdGruppo() {
		return idGruppo;
	}

	public void setIdGruppo(Integer idGruppo) {
		this.idGruppo = idGruppo;
	}

	public String getNomeGruppo() {
		return nomeGruppo;
	}

	public void setNomeGruppo(String nomeGruppo) {
		this.nomeGruppo = nomeGruppo;
	}

	public String getInfoGruppo() {
		return infoGruppo;
	}

	public void setInfoGruppo(String infoGruppo) {
		this.infoGruppo = infoGruppo;
	}

	public byte[] getFotoGruppo() {
		return fotoGruppo;
	}

	public void setFotoGruppo(byte[] fotoGruppo) {
		this.fotoGruppo = fotoGruppo;
	}

	public Integer getAmministratoreGruppo() {
		return amministratoreGruppo;
	}

	public void setAmministratoreGruppo(Integer amministratoreGruppo) {
		this.amministratoreGruppo = amministratoreGruppo;
	}

	public Utente getAmministratore() {
		return amministratore;
	}

	public void setAmministratore(Utente amministratore) {
		this.amministratore = amministratore;
	}

	public List<Messaggio> getListaMessaggiGruppo() {
		return listaMessaggiGruppo;
	}

	public void setListaMessaggiGruppo(List<Messaggio> listaMessaggiGruppo) {
		this.listaMessaggiGruppo = listaMessaggiGruppo;
	}

	public List<Chiamata> getChiamateGruppo() {
		return chiamateGruppo;
	}

	public void setChiamateGruppo(List<Chiamata> chiamateGruppo) {
		this.chiamateGruppo = chiamateGruppo;
	}


    
	
}
