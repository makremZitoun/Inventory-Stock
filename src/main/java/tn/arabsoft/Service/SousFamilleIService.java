package tn.arabsoft.Service;

import java.util.List;


import tn.arabsoft.entities.SousFamille;

public interface SousFamilleIService extends CrudService<SousFamille> {

	public SousFamille getSousFamilleByNom(String nomDeSousCategorie);
	public List<SousFamille> getsousFamilleBynomFamille(String nomCategorie);
	
	
}
