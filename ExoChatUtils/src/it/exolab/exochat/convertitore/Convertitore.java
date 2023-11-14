package it.exolab.exochat.convertitore;

import java.util.ArrayList;
import java.util.List;

import it.exolab.exochat.model.Utente;

public class Convertitore {


	public Utente convertUtenteToDto(Utente utente) {
		Utente utenteDTO = new Utente();
		utenteDTO.setIdUtente(utente.getIdUtente());
		utenteDTO.setUsername(utente.getUsername());
		utenteDTO.setEmail(utente.getEmail());
		if(null != utente.getInfo()) {
			utenteDTO.setInfo(utente.getInfo());
		}
		if(null != utente.getFoto()) {
			utenteDTO.setFoto(utente.getFoto());
		}
		return utenteDTO;
	}
	
	public List<Utente> convertListaUtenteToDto(List<Utente> listaUtenti) {
		List <Utente> utentiDto = new ArrayList<Utente>();	
		for(Utente utente : listaUtenti) {
			Utente utenteDto = convertUtenteToDto(utente);
			utentiDto.add(utenteDto);
		}
		return utentiDto;		
	}
	
	
}
