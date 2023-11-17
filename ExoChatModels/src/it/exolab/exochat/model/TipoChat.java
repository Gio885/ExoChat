package it.exolab.exochat.model;

import java.io.Serializable;
import java.util.List;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

@Entity
@Table(name = "TIPO_CHAT")
public class TipoChat implements Serializable{

	private static final long serialVersionUID = -3827103758971773344L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TIPO_CHAT")
    private Integer idTipoChat;

    @Column(name = "TIPOLOGIA", nullable = false)
    private String tipologia;
    
    @JsonbTransient
    @OneToMany(mappedBy = "tipoChat",fetch = FetchType.LAZY)
    private List<Chat> listaChat;

	public Integer getIdTipoChat() {
		return idTipoChat;
	}

	public void setIdTipoChat(Integer idTipoChat) {
		this.idTipoChat = idTipoChat;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public List<Chat> getListaChat() {
		return listaChat;
	}

	public void setListaChat(List<Chat> listaChat) {
		this.listaChat = listaChat;
	}
    
 
	
	
	
    
}
