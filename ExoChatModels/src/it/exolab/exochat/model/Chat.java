package it.exolab.exochat.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Chat implements Serializable{

	private static final long serialVersionUID = 763492618062143512L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CHAT")
    private int idChat;

    @ManyToOne
    @JoinColumn(name = "TIPO_CHAT_ID", nullable = false)
    private TipoChat tipoChat;

    
    
    
	public int getIdChat() {
		return idChat;
	}

	public void setIdChat(int idChat) {
		this.idChat = idChat;
	}

	public TipoChat getTipoChat() {
		return tipoChat;
	}

	public void setTipoChat(TipoChat tipoChat) {
		this.tipoChat = tipoChat;
	}
    
    
    
    
}