package tn.arabsoft.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.arabsoft.Service.ComptageIService;
import tn.arabsoft.entities.ArticleByGroupNB;
import tn.arabsoft.entities.Comptage;
import tn.arabsoft.entities.Inventaire;
import tn.arabsoft.entities.Materiel;
import tn.arabsoft.entities.Utilisateur;

@RestController
@RequestMapping(value ="/comptage")
public class ComptageRest implements CrudRest<Comptage>{
	
	@Autowired
	private ComptageIService cS;

	@RequestMapping(value="/save",method=RequestMethod.POST)
	@Override
	public Comptage save(@RequestBody Comptage t) {
		// TODO Auto-generated method stub
		return cS.save(t);
	}

	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	@Override
	public List<Comptage> getAll() {
		// TODO Auto-generated method stub
		return cS.getAll();
	}

	@RequestMapping(value="/get/{id}",method=RequestMethod.GET)
	@Override
	public Comptage getOne(int id) {
		// TODO Auto-generated method stub
		return cS.getOne(id);
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return cS.delete(id);
	}
	
	@RequestMapping(value="/verifierArticleInventorier/{idA}",method=RequestMethod.GET)
		public int verifierArticleInventorier(@PathVariable int idA) {
		// TODO Auto-generated method stub
		return cS.verifierArticleInventorie(idA);
	}
	
	@RequestMapping(value="/updateComptageUtilisateur/{idI}/{idM}",method=RequestMethod.PUT)
	public int updateComptageUtilisateur(@RequestBody Utilisateur u , @PathVariable int idI,@PathVariable  int idM)
	{
		return this.cS.updateComptageUtilisateur(u, idI, idM);
	}
	
	@RequestMapping(value="/getInventaireByUser/{idU}",method=RequestMethod.GET)
	public List<Inventaire> getInventaireByUser(@PathVariable Long idU )
	{
		return this.cS.getInventaireByUser(idU);
	}
	
	@RequestMapping(value="/getNbArticleByInventaire/{idInv}/{idU}",method=RequestMethod.GET)
	public int getNbArticleByInventaire(@PathVariable int idInv, @PathVariable Long idU)
	{
		return this.cS.getNbArticleByInventaire(idInv, idU);
	}
	
	@RequestMapping(value="/getInventaireEncoursPlanifierByUser/{idU}",method=RequestMethod.GET)
	public List<Inventaire> getInventaireEncoursPlanifierByUser(@PathVariable Long idU )
	{
		return this.cS.getInventaireEncoursPlanifierByUser(idU);
	}
	
	@RequestMapping(value="/getMaterielByInvUser/{idU}/{idI}",method=RequestMethod.GET)
	public List<Materiel> getMaterielByInvUser(Long idU, int idI)
	{
		return this.cS.getMaterielByInvUser(idU, idI);
	}
	
	
	@RequestMapping(value="/getNBFamille/{idM}",method=RequestMethod.GET)
	public List<ArticleByGroupNB> getNBFamille(@PathVariable int idM)
	{
		return this.cS.getNbFamille(idM);
	}
	
	@RequestMapping(value="/getC/{idM}/{idA}",method=RequestMethod.GET)
	public String getC(@PathVariable  int idM, @PathVariable int idA) {
		// TODO Auto-generated method stub
		return cS.getC(idM, idA);
	}
	
	@RequestMapping(value="/updateComptageUtilisateur1/{idU}/{idM}/{idI}",method=RequestMethod.PUT)
	public Comptage updateComptageUtilisateur1(@PathVariable Long idU , @PathVariable int idM,	@PathVariable  int idI)
	{		
		return this.cS.updateComptageUtilisateur1(idU , idM, idI);
				
	}
	
	@RequestMapping(value="/getUserComptage/{idI}",method=RequestMethod.GET)
	public List<Utilisateur> getUserComptage(@PathVariable  int idI)
	{
		return this.cS.getUserComptage(idI);
	}
	
	@RequestMapping(value="/updateQtePhyComptage/{idU}/{idM}/{idI}/{qte}",method=RequestMethod.PUT)
	public Comptage updateQtePhyComptage(@PathVariable Long idU,@PathVariable int idM, @PathVariable  int idI, @PathVariable  int qte)
	{		
		return this.cS.updateQtePhyComptage(idU, idM, idI, qte);
				
	}
	
	@RequestMapping(value="/getUserDeuxComptage/{idI}",method=RequestMethod.GET)
	public List<Utilisateur> getUserDeuxComptage(@PathVariable  int idI)
	{
		return this.cS.getUserDeuxComptage(idI);
	}
	
	@RequestMapping(value="/updateQtePhyDeuxComptage/{idU}/{idM}/{idI}/{qte}",method=RequestMethod.PUT)
	public Comptage updateQtePhyDeuxComptage(@PathVariable Long idU,@PathVariable int idM, @PathVariable  int idI, @PathVariable  int qte)
	{		
		return this.cS.updateQtePhyDeuxComptage(idU, idM, idI, qte);
				
	}
	

}
