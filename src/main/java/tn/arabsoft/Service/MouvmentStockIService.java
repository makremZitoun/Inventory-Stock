package tn.arabsoft.Service;
import java.util.List;

import tn.arabsoft.entities.Document;
import tn.arabsoft.entities.Etat;
import tn.arabsoft.entities.MouvementDeStock;
import tn.arabsoft.entities.MvGroupByEtat;
import tn.arabsoft.entities.MvGroupByUserAndEtat;
import tn.arabsoft.entities.PageMouvement;
import tn.arabsoft.entities.PageMouvementUtilisateur;
import tn.arabsoft.entities.PageMouvmentDate;

public interface MouvmentStockIService extends CrudService<MouvementDeStock>  {

	public int getNbMouvement();
	public int getNbSortie();
	public List<MvGroupByUserAndEtat> getNbMouvmentByUser_Etat();
	public List<MvGroupByEtat> getNBMouvmentByEtat();
	public List<MouvementDeStock> getMouvementByEtat(Etat etatM);
	public PageMouvement getPageMouvementByEtat(Etat etatM,int page , int size);
	public PageMouvmentDate getMouvementByEtatDuree(Etat EtatM , int idM ,int page , int size);
	public MouvementDeStock updateEtatMouvemnt(Etat etatM ,int id);
	public MouvementDeStock updateDocumentMouvemnt(Document d ,int id);
	public PageMouvementUtilisateur getMouvementByUtilisateur(String username , int page , int size);
	public PageMouvmentDate getMouvementByTypeDuree(String typeE ,int idM ,int page , int size);
	public PageMouvmentDate getMouvementByDateDuree(String dateM ,int idM ,int page , int size);
	
	public PageMouvmentDate getSortieByDateDuree(String dateM ,int idM ,int page , int size);
	public PageMouvmentDate getSortieByTypeDuree(String typeE ,int idM ,int page , int size);
	public PageMouvmentDate getSortieByEtatDuree(Etat EtatM , int idM ,int page , int size);
	
	
}
