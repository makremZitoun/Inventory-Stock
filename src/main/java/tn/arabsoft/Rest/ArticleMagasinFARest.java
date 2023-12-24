package tn.arabsoft.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.arabsoft.Service.ArticleMagasinFAIService;
import tn.arabsoft.entities.ArticleMagasinFicheArticle;
import tn.arabsoft.entities.FicheArticle;
import tn.arabsoft.entities.Materiel;
import tn.arabsoft.entities.PageArticleMagasin;

@RestController
@RequestMapping(value ="/ArticleMagasin")
public class ArticleMagasinFARest implements CrudRest<ArticleMagasinFicheArticle> {

	@Autowired
	private ArticleMagasinFAIService aS;

	@RequestMapping(value="/save",method=RequestMethod.POST)
	@Override
	public ArticleMagasinFicheArticle save(@RequestBody ArticleMagasinFicheArticle t) {
		// TODO Auto-generated method stub
		return aS.save(t);
	}

	@Override
	public List<ArticleMagasinFicheArticle> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleMagasinFicheArticle getOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@RequestMapping(value="/getFA/{idA}/{idM}",method=RequestMethod.GET)
	public FicheArticle getFicheArticle(@PathVariable("idA") int idA, @PathVariable("idM") int idM)
	{
		return aS.getFicheArticle(idA, idM);
	}

	@RequestMapping(value="/getArticleByMagasin/{idM}/{page}/{size}",method=RequestMethod.GET)
	public PageArticleMagasin getArticleByMagasin(@PathVariable("idM") int idM, @PathVariable int page , @PathVariable int size){
		return aS.getArticleByMagasin(idM,page,size);
	}

	@RequestMapping(value="/getArticleByMagasinListe/{idM}",method=RequestMethod.GET)
	public List<Materiel> getArticleByMagasinListe(@PathVariable("idM") int idM){
		return aS.getArticleByMagasinListe(idM);
	}
	
	@RequestMapping(value="/getArticleByMagasinCategorie/{idM}/{nomF}",method=RequestMethod.GET)
	public List<Materiel> getArticleByMagasinCategorie(@PathVariable("idM") int idM, @PathVariable("nomF") String nomF) 
	{
		return aS.getArticleByMagasinCategorie(idM, nomF);}



}
