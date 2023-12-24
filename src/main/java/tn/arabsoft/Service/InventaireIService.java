package tn.arabsoft.Service;
import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import tn.arabsoft.entities.Etat;
import tn.arabsoft.entities.EtatInv;
import tn.arabsoft.entities.Inventaire;


public interface InventaireIService extends CrudService<Inventaire> {
	
	public Inventaire updatedate2Inventaire(Date dateI,int idI);
	public Inventaire updateEtatInventaire(EtatInv etatI,int idI);
	public List<Inventaire> getEtatByEtatTerminer();
}
