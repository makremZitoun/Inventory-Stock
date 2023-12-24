package tn.arabsoft.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.arabsoft.Service.FicheStockIservice;
import tn.arabsoft.entities.FicheStock;
import tn.arabsoft.entities.PageFicheStock;
import tn.arabsoft.entities.PageMvCmdDelai;

@RestController
@RequestMapping(value="/ficheStock" )
public class FicheStockRest implements CrudRest<FicheStock> {

	@Autowired
	private FicheStockIservice fS;
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@Override
	public FicheStock save(@RequestBody FicheStock t) {
		// TODO Auto-generated method stub
		return fS.save(t);
	}

	@Override
	public List<FicheStock> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FicheStock getOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@RequestMapping(value="/getFSbyMouvment/{idM}/{page}/{size}",method=RequestMethod.GET)
	public PageFicheStock getFSbyMouvment(@PathVariable int idM ,@PathVariable int page,@PathVariable int size) {
		// TODO Auto-generated method stub
		return fS.findFSbyMouvmemnt(idM, page, size);
	}

	@RequestMapping(value="/getFSbyArticle/{id}/{idM}/{page}/{size}",method=RequestMethod.GET)
	public PageFicheStock getFSbyArticle(@PathVariable int id ,@PathVariable int idM, @PathVariable int page,@PathVariable int size) {
		// TODO Auto-generated method stub
		return fS.getFSByArticle(id,idM, page, size);
	}
	
	@RequestMapping(value="/getFSbyArticleS/{id}/{idM}/{page}/{size}",method=RequestMethod.GET)
	public PageFicheStock getFSbyArticleS(@PathVariable int id ,@PathVariable int idM, @PathVariable int page,@PathVariable int size) {
		// TODO Auto-generated method stub
		return fS.getFSByArticleS(id,idM,page,size);
	}
	
	@RequestMapping(value="/getFSbyArticleA/{id}/{idM}/{page}/{size}",method=RequestMethod.GET)
	public PageFicheStock getFSbyArticleA(@PathVariable int id ,@PathVariable int idM, @PathVariable int page,@PathVariable int size) {
		// TODO Auto-generated method stub
		return fS.getFSByArticleA(id,idM,page,size);
	}
	
	@RequestMapping(value="/getMvCmdDelai/{idA}/{idM}/{page}/{size}",method=RequestMethod.GET)
	public PageMvCmdDelai getMvCmdDelai(@PathVariable int idA,@PathVariable int idM, @PathVariable int page,@PathVariable int size) {
		// TODO Auto-generated method stub
		return fS.getMvCmdDelai(idA,idM, page, size);
	}
	
	@RequestMapping(value="/getFSByIntervalle/{idA}/{idM}/{dateD}/{dateF}",method=RequestMethod.GET)
	public List<FicheStock> getFSByIntervalle(@PathVariable int idA,@PathVariable int idM,@PathVariable String dateD,@PathVariable String dateF) {
		// TODO Auto-generated method stub
		return fS.getFSByIntervalle(idA, idM, dateD, dateF);
	}
	
	@RequestMapping(value="/getFSByMouvement/{idMv}",method=RequestMethod.GET)
	public List<FicheStock> getFSByMouvement(@PathVariable int idMv) {
		// TODO Auto-generated method stub
		return fS.getFicheStockByMouvement(idMv);
	}
	
}
