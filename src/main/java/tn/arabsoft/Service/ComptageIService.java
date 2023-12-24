package tn.arabsoft.Service;
import java.util.List;

import org.springframework.data.repository.query.Param;

import tn.arabsoft.entities.ArticleByGroupNB;
import tn.arabsoft.entities.Comptage;
import tn.arabsoft.entities.Inventaire;
import tn.arabsoft.entities.Materiel;
import tn.arabsoft.entities.Utilisateur;

public interface ComptageIService extends CrudService<Comptage> {

	public int verifierArticleInventorie(int idA);
	public int updateComptageUtilisateur(Utilisateur u,int idI,int idM);
	public List<Inventaire> getInventaireByUser(Long idU );
	public int getNbArticleByInventaire(int idInv,Long idU);
	public List<Inventaire> getInventaireEncoursPlanifierByUser(Long idU );
	public List<Materiel> getMaterielByInvUser(Long idU,int idI);
	public List<ArticleByGroupNB> getNbFamille(int idM);
	public String getC(int idM, int idA);
	public Comptage updateComptageUtilisateur1(Long idU,  int idM,int idI);
	public List<Utilisateur> getUserComptage( int idI); 
	public Comptage updateQtePhyComptage(Long idU,int idM,int idI,int qte);
	public List<Utilisateur> getUserDeuxComptage(int idI); 
	public Comptage updateQtePhyDeuxComptage(Long idU,int idM,int idI,int qte);
}
