package tn.arabsoft.Service;


import java.util.List;

import tn.arabsoft.entities.Materiel;
import tn.arabsoft.entities.SousFamille;

public interface MaterielIService extends CrudService<Materiel> {

	public PageMateriel findAll(int idM,int page , int size);
//	public Materiel findByCB (String code) ;
	public int Updatemateriel(SousFamille sc , int id);
	public List<Materiel> getArticleByRef(String ref);
//	public PageMateriel getArticleDeCommande(int page, int size);
	public PageMateriel getArticleDeCommandeParMagasin(int idM , int page, int size);
//	public List<Materiel> getArticleParMagasin(int idM , String ref);
}
