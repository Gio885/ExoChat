package it.exolab.exochat.convertitore;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import it.exolab.exochat.costanti.Costanti;
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
	
	public Date dataDaFormattare(Date data) throws Exception {
		try {
			SimpleDateFormat formatoData = new SimpleDateFormat("dd MMM yy", Locale.ITALIAN);
	        String dataFormattataString = formatoData.format(new Date());
	        Date dataFormattata = formatoData.parse(dataFormattataString);
	        return dataFormattata;	        
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore metodo dataDaFormattare --- ERRORE CONVERSIONE DATA --- ");
			throw new Exception (Costanti.ERRORE_CONTATTA_ASSISTENZA);
		}
	}
	
}
