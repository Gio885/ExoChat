package it.exolab.exochat.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class TipoChat implements Serializable{

	private static final long serialVersionUID = -3827103758971773344L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TIPO_CHAT")
    private int idTipoChat;

    @Column(name = "TIPOLOGIA", nullable = false)
    private String tipologia;
    
    
    
    
    

	public int getIdTipoChat() {
		return idTipoChat;
	}

	public void setIdTipoChat(int idTipoChat) {
		this.idTipoChat = idTipoChat;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
    
}
