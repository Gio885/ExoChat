package it.exolab.exochat.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

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
    @OneToMany(mappedBy = "chat", fetch = FetchType.LAZY)
    private List<Messaggio> listaMessaggiChat;
    
    

	@Override
	public int hashCode() {
		return Objects.hash(idChat);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chat other = (Chat) obj;
		return Objects.equals(idChat, other.idChat);
	}

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
