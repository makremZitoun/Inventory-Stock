package tn.arabsoft.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.arabsoft.Service.CommandeArticleIService;
import tn.arabsoft.entities.ArticleApprouve;
import tn.arabsoft.entities.ArticleQuantite;
import tn.arabsoft.entities.CommandeArticle;
import tn.arabsoft.entities.Etat;

@RestController
@RequestMapping(value ="/commandeArticle")
public class CommandeArticleRest implements CrudRest<CommandeArticle>{

	@Autowired
	private CommandeArticleIService caS;
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@Override
	public CommandeArticle save(@RequestBody CommandeArticle t) {
		// TODO Auto-generated method stub
		return caS.save(t);
	}

	@Override
	public List<CommandeArticle> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommandeArticle getOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@RequestMapping(value="/getArticleDeCommande/{idC}",method=RequestMethod.GET)
	public List<ArticleQuantite> getArticleDeCommande(@PathVariable int idC) {
		// TODO Auto-generated method stub
		return caS.getArticleDeCommande(idC);
	}
	
	@RequestMapping(value="/getArticleApprouve/{idC}",method=RequestMethod.GET)
	public List<ArticleApprouve> getArticleApprouve(@PathVariable int idC) {
		
		return caS.getArticleApprouve(idC);
	}

	
	@RequestMapping(value="/updateQteApprouve/{idC}/{idA}/{qte}",method=RequestMethod.PUT)
	public CommandeArticle updateQteApprouve(@PathVariable int idC ,@PathVariable int idA , @PathVariable int qte) {

		 
		 return caS.updateQteApprouve(idC, idA, qte);
		 
	}
	
	@RequestMapping(value="/updateQteFournie/{idC}/{idA}/{qte}",method=RequestMethod.PUT)
	public CommandeArticle updateQteFournie(@PathVariable int idC ,@PathVariable int idA , @PathVariable int qte) {

		 
		 return caS.updateQteFournie(idC, idA, qte);
		 
	}
	
	@RequestMapping(value="/getCommandeByEtat/{etatC}/{idC}",method=RequestMethod.GET)
	public List<CommandeArticle> getCommandeByEtat(@PathVariable Etat etatC ,@PathVariable int idC ) {

		 
		 return caS.getCommandeArticleByEtat(etatC, idC);
		 
	}
	
	@RequestMapping(value="/getArticleApprouveCmd/{idC}",method=RequestMethod.GET)
	public List<CommandeArticle> getArticleApprouveCmd(@PathVariable("idC") int idC){

		 
		 return caS.getArticleApprouveCmd(idC);
		 
	}
	
}
