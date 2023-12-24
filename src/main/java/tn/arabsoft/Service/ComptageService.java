package tn.arabsoft.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.arabsoft.Dao.ComptageRepository;
import tn.arabsoft.entities.ArticleByGroupNB;
import tn.arabsoft.entities.Comptage;
import tn.arabsoft.entities.Inventaire;
import tn.arabsoft.entities.Materiel;
import tn.arabsoft.entities.Utilisateur;

@Service
public class ComptageService implements ComptageIService {

	@Autowired
	private ComptageRepository cR ;
	
	@Override
	public Comptage save(Comptage t) {
		// TODO Auto-generated method stub
		return cR.save(t);
	}

	@Override
	public List<Comptage> getAll() {
		// TODO Auto-generated method stub
		return cR.findAll();
	}

	@Override
	public Comptage getOne(int id) {
		// TODO Auto-generated method stub
		return cR.findById(id).get();
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		cR.deleteById(id);
		return id;
	}
	
	@Override
	public int verifierArticleInventorie(int idA) {
		int res = 0 ;
		
		if(cR.verifierArticleInventorie(idA) != null)
		{ res=1 ;}
		// TODO Auto-generated method stub
		return res;
	}
	
	@Override
	public int updateComptageUtilisateur(Utilisateur u, int idI, int idM) {
		// TODO Auto-generated method stub
		return this.cR.updateComptageUtilisateur(u, idI, idM);
	}

	public ComptageService() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<Inventaire> getInventaireByUser(Long idU) {
		// TODO Auto-generated method stub
		return this.cR.getInventaireByUser(idU);
	}
	
	@Override
	public int getNbArticleByInventaire(int idInv, Long idU) {
		// TODO Auto-generated method stub
		return this.cR.getNbArticleByInventaire(idInv, idU);
	}
	
	@Override
	public List<Inventaire> getInventaireEncoursPlanifierByUser(Long idU) {
		// TODO Auto-generated method stub
		return this.cR.getInventaireEncoursPlanifierByUser(idU);
	}
	
	@Override
	public List<Materiel> getMaterielByInvUser(Long idU, int idI) {
		// TODO Auto-generated method stub
		return this.cR.getMaterielByInvUser(idU,idI);
	}
	
	@Override
	public List<ArticleByGroupNB> getNbFamille(int idM) {
		// TODO Auto-generated method stub
		return this.cR.getNbFamille(idM);
	}
	
	@Override
	public String getC(int idM,int idA) {
		// TODO Auto-generated method stub
		return cR.getC(idM, idA);
	}

	@Override
	public Comptage updateComptageUtilisateur1(Long idU, int idM, int idI) {
	// TODO Auto-generated method stub
	
			cR.updateComptageUtilisateur1(idU, idM, idI);
			return  new Comptage();
	}
	
	@Override
	public List<Utilisateur> getUserComptage(int idI) {
		// TODO Auto-generated method stub
		return cR.getUserComptage(idI);
	}
	
	@Override
	public Comptage updateQtePhyComptage(Long idU, int idM, int idI, int qte) {
		// TODO Auto-generated method stub
		cR.updateQtePhyComptage(idU, idM, idI, qte);
		return  new Comptage();
	}
	
	@Override
	public List<Utilisateur> getUserDeuxComptage(int idI) {
		// TODO Auto-generated method stub
		return cR.getUserDeuxComptage(idI);
	}
	
	@Override
	public Comptage updateQtePhyDeuxComptage(Long idU, int idM, int idI, int qte) {
		// TODO Auto-generated method stub
		cR.updateQtePhyDeuxComptage(idU, idM, idI, qte);
		return  new Comptage();
	}
}
