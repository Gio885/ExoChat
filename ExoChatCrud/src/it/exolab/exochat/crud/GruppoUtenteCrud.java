package it.exolab.exochat.crud;

import java.util.List;

import javax.persistence.EntityManager;

import it.exolab.exochat.costanti.Costanti;
import it.exolab.exochat.model.GruppoUtente;

public class GruppoUtenteCrud extends BaseCrud <GruppoUtente> {

	
	private BaseCrud <GruppoUtente> baseCrud = new BaseCrud <GruppoUtente>();
	
    public void insertGruppoUtente(List<GruppoUtente> listaUtentiGruppo, EntityManager entityManager) throws Exception {
        try {
        	for(GruppoUtente utenteDaAssociareAlGruppo : listaUtentiGruppo) {
                baseCrud.insert(utenteDaAssociareAlGruppo, entityManager);
                entityManager.clear();
        	}
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Errore insertGruppoUtente ---GruppoUtenteCrud");
			throw new Exception(Costanti.ERRORE_INSERIMENTO_UTENTI_GRUPPO);
        }
    }


}
