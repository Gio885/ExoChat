package it.exolab.exochat.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Gruppo implements Serializable {

	private static final long serialVersionUID = -3923397912562921521L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_GRUPPO")
    private int idGruppo;

    @Column(name = "NOME_GRUPPO", nullable = false)
    private String nomeGruppo;

    @Column(name = "INFO_GRUPPO")
    private String infoGruppo;

    @Lob
    @Column(name = "FOTO_GRUPPO")
    private byte[] fotoGruppo;

    @ManyToOne
    @JoinColumn(name = "AMMINISTRATOREl", nullable = false)
    private Utente amministratore;

    
    
    
    
	public int getIdGruppo() {
		return idGruppo;
	}

	public void setIdGruppo(int idGruppo) {
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

	public Utente getAmministratore() {
		return amministratore;
	}

	public void setAmministratore(Utente amministratore) {
		this.amministratore = amministratore;
	}

    
	
}
