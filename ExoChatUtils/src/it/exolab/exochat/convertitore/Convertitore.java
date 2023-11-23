package it.exolab.exochat.convertitore;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import it.exolab.exochat.costanti.Costanti;
import it.exolab.exochat.dto.AccountDto;
import it.exolab.exochat.dto.MessaggioDto;
import it.exolab.exochat.model.Gruppo;
import it.exolab.exochat.model.Messaggio;
import it.exolab.exochat.model.Utente;

public class Convertitore {

	
	public Utente convertDtoToUtente(AccountDto utenteDto) {
		Utente utente = new Utente();
		utente.setIdUtente(utenteDto.getIdUtente());
		utente.setUsername(utenteDto.getUsername());
		utente.setEmail(utenteDto.getEmail());
		utente.setPassword(utenteDto.getPassword());
		utente.setInfo(utenteDto.getInfo());	
        byte[] fotoArrayByte = Base64.getDecoder().decode(utenteDto.getFotoConvertita());
		utente.setFoto(fotoArrayByte);
		return utente;
	}
	

	public AccountDto convertUtenteToDto(Utente utente) {
		AccountDto accountDto = new AccountDto();
		accountDto.setIdUtente(utente.getIdUtente());;
		accountDto.setUsername(utente.getUsername());
		accountDto.setEmail(utente.getEmail());
		accountDto.setInfo(utente.getInfo());			
		String foto = Base64.getEncoder().encodeToString(utente.getFoto());
		accountDto.setFotoConvertita(foto);
		return accountDto;
	}
	
	public List<AccountDto> convertListaUtenteToDto(List<Utente> listaUtenti) {
		List <AccountDto> listaAccountDto = new ArrayList<AccountDto>();	
		for(Utente utente : listaUtenti) {
			AccountDto accountDto = convertUtenteToDto(utente);
			listaAccountDto.add(accountDto);
		}
		return listaAccountDto;		
	}
	
	public AccountDto convertGruppoToDto(Gruppo gruppo) {
		AccountDto accountDto = new AccountDto();
		accountDto.setIdUtente(gruppo.getIdGruppo());
		accountDto.setUsername(gruppo.getNomeGruppo());
		accountDto.setInfo(gruppo.getInfoGruppo());
		String foto = Base64.getEncoder().encodeToString(gruppo.getFotoGruppo());
		accountDto.setFotoConvertita(foto);
		accountDto.setAmministratoreGruppo(convertUtenteToDto(gruppo.getAmministratore()));		
		return accountDto;
	}
	
	public List<AccountDto> convertListaGruppoToDto(List<Gruppo> listaGruppo) {
		List <AccountDto> listaAccountDto = new ArrayList<AccountDto>();	
		for(Gruppo gruppo : listaGruppo) {
			AccountDto accountDto = convertGruppoToDto(gruppo);
			listaAccountDto.add(accountDto);
		}
		return listaAccountDto;		
	}
	
	
	public MessaggioDto convertMessaggioToDto(Messaggio messaggio) {
		MessaggioDto messaggioDto = new MessaggioDto();
		messaggioDto.setIdMessaggio(messaggio.getIdMessaggio());
		messaggioDto.setMittente(convertUtenteToDto(messaggio.getMittente()));
		if(Costanti.TIPO_CHAT_SINGOLA == messaggio.getChat().getTipoChatId()) {
			messaggioDto.setDestinatario(convertUtenteToDto(messaggio.getDestinatario()));
		}
		if(Costanti.TIPO_CHAT_GRUPPO == messaggio.getChat().getTipoChatId()) {
			messaggioDto.setGruppo(convertGruppoToDto(messaggio.getGruppo()));
		}
		messaggioDto.setContenutoMessaggio(messaggio.getContenutoMessaggio());
		messaggioDto.setDataOra(messaggio.getDataOra());
		messaggioDto.setIdChat(messaggio.getChat().getIdChat());
		messaggioDto.setTipoChatId(messaggio.getChat().getTipoChatId());
		return messaggioDto;
	}
	
	public List<MessaggioDto> convertListaMessaggioToDto(List<Messaggio> listaMessaggi) {
		List<MessaggioDto> listaMessaggioDto = new ArrayList<MessaggioDto>();	
		for(Messaggio messaggio : listaMessaggi) {
			MessaggioDto messaggioDto = convertMessaggioToDto(messaggio);
			listaMessaggioDto.add(messaggioDto);
		}
		return listaMessaggioDto;		
	}
	
	
	
	

	
}
