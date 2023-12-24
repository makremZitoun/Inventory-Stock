package tn.arabsoft.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.arabsoft.Service.FicheArticleIService;
import tn.arabsoft.entities.FicheArticle;

@RestController
@RequestMapping(value ="/ficheArticle")
public class FicheArticleRest implements CrudRest<FicheArticle> {

	@Autowired
	private FicheArticleIService faS;

	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@Override
	public FicheArticle save(@RequestBody FicheArticle t) {
		// TODO Auto-generated method stub
		return faS.save(t);
	}

	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	@Override
	public List<FicheArticle> getAll() {
		// TODO Auto-generated method stub
		return faS.getAll();
	}

	@RequestMapping(value="/get/{id}",method=RequestMethod.GET)
	@Override
	public FicheArticle getOne(@PathVariable int id) {
		// TODO Auto-generated method stub
		return faS.getOne(id);
	}

	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	@Override
	public int delete(@PathVariable int id) {
		// TODO Auto-generated method stub
		return faS.delete(id);
	}

	@RequestMapping(value="/getFicheArticleByMagasinArticle/{idM}/{idA}",method=RequestMethod.GET)
	public List<FicheArticle> getFicheArticleByMagasinArticle(@PathVariable int idM , @PathVariable int  idA)
	{
		return faS.getFicheArticleByMagasinArticle(idM, idA);
	}
	
	@RequestMapping(value="/updateFicheArticleS/{idFA}/{qte}",method=RequestMethod.PUT)
	public FicheArticle updateFicheArticleS(@PathVariable int idFA, @PathVariable int qte){
		return faS.updateFicheArticleS(idFA,qte);
	}
	
	@RequestMapping(value="/updateFicheArticleE/{idFA}/{qte}",method=RequestMethod.PUT)
	public FicheArticle updateFicheArticleE(@PathVariable int idFA,@PathVariable  int qte){
		return faS.updateFicheArticleE(idFA,qte);
	}
	
	@RequestMapping(value="/updateStockMinSecAlert/{idFA}/{sMin}/{sSec}/{sAlert}",method=RequestMethod.PUT)
	public FicheArticle updateStockMinSecAlert(@PathVariable int idFA, @PathVariable  int sMin ,@PathVariable int sSec ,@PathVariable  int sAlert ){
		return faS.updateStockMinSecAlert(idFA, sMin, sSec, sAlert);
	}

	@RequestMapping(value="/updateStockTheorique/{idFA}/{qte}",method=RequestMethod.PUT)
	public FicheArticle updateStockTheorique(@PathVariable int idFA, @PathVariable  int qte){
		return faS.updateStockTheorique(idFA, qte);
	}
}
