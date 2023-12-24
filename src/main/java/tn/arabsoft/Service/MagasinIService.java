package tn.arabsoft.Service;

import java.util.List;

import tn.arabsoft.entities.Magasin;

public interface MagasinIService extends CrudService<Magasin>  {

	public List<Magasin> getMagasinFournisseur();
	public List<Magasin> getMagasinClient();

}
