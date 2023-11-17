package it.exolab.exochat.model;

import java.io.Serializable;
import java.util.List;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

@Entity
@Table(name = "CHAT")
public class Chat implements Serializable{

	private static final long serialVersionUID = 763492618062143512L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CHAT")
    private Integer idChat;
	
    @Column(name = "TIPO_CHAT_ID",nullable = false)
	private Integer tipoChatId;
	
    @ManyToOne
    @JoinColumn(name = "TIPO_CHAT_ID", insertable = false, updatable = false)
    private TipoChat tipoChat;
    
    @JsonbTransient
    @OneToMany(mappedBy = "chat",fetch = FetchType.LAZY)
    private List<Messaggio> listaMessaggiChat;

	public Integer getIdChat() {
		return idChat;
	}

	public void setIdChat(Integer idChat) {
		this.idChat = idChat;
	}

	public Integer getTipoChatId() {
		return tipoChatId;
	}

	public void setTipoChatId(Integer tipoChatId) {
		this.tipoChatId = tipoChatId;
	}

	public TipoChat getTipoChat() {
		return tipoChat;
	}

	public void setTipoChat(TipoChat tipoChat) {
		this.tipoChat = tipoChat;
	}

	public List<Messaggio> getListaMessaggiChat() {
		return listaMessaggiChat;
	}

	public void setListaMessaggiChat(List<Messaggio> listaMessaggiChat) {
		this.listaMessaggiChat = listaMessaggiChat;
	}
   
    
    
    
    
}
