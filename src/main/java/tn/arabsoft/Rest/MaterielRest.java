package tn.arabsoft.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.arabsoft.Service.PageMateriel;
import tn.arabsoft.Service.MaterielIService;
import tn.arabsoft.entities.Materiel;
import tn.arabsoft.entities.SousFamille;

@RestController
@RequestMapping(value ="/materiel")
public class MaterielRest implements CrudRest<Materiel>{

	@Autowired
	private MaterielIService pS ;


	@RequestMapping(value="/save",method=RequestMethod.POST)
	@Override
	public Materiel save(@RequestBody	Materiel t) {
		// TODO Auto-generated method stub
		return pS.save(t);
	}
	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	@Override
	public List<Materiel> getAll() {
		// TODO Auto-generated method stub
		return pS.getAll();
	}
	
	@RequestMapping(value="/getByRef/{ref}",method=RequestMethod.GET)
	public List<Materiel> getByRef(@PathVariable String ref) {
		// TODO Auto-generated method stub
		return pS.getArticleByRef(ref);
	}
//	
	@RequestMapping(value="/get/{id}",method=RequestMethod.GET)
	@Override
	public Materiel getOne(@PathVariable	int id) {
		// TODO Auto-generated method stub
		return pS.getOne(id);
	}

	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	@Override
	public int delete(@PathVariable	int id) {
		// TODO Auto-generated method stub
		return pS.delete(id);
	}
	
//	@RequestMapping(value="/getByCB/{cb}",method=RequestMethod.GET)
//	public Materiel getByCB(@PathVariable String cb) {
//		// TODO Auto-generated method stub
//		return pS.findByCB(cb);
//	}
	
	@RequestMapping(value="/edit",method=RequestMethod.PUT)
	public Materiel editmateriel(@RequestBody Materiel p) {
		// TODO Auto-generated method stub
		return pS.save(p);
	}
	
	@RequestMapping(value="/setSousCategorie/{idp}",method=RequestMethod.PUT)
	public int editmateriel(@PathVariable int idp ,@RequestBody SousFamille sc ) {
		// TODO Auto-generated method stub
//		 materiel p = pS.getOne(idp) ;
//		p.setSousCategorie(sc);
		return pS.Updatemateriel(sc, idp);
	}
	
	@RequestMapping(value="/getAllPagination/{idM}/{page}/{size}",method=RequestMethod.GET)
	public PageMateriel getAllPagination(@PathVariable int idM ,@PathVariable int page,@PathVariable int size) {
		//System.out.println(pS.findAll(page, size).toString());
		
		return pS.findAll(idM ,page, size);
	}
	
//	@RequestMapping(value="/getArticleDeCommande/{page}/{size}",method=RequestMethod.GET)
//	public PageMateriel getArticleDeCommande(@PathVariable int page,@PathVariable int size) {
//		//System.out.println(pS.findAll(page, size).toString());
//		
//		return pS.getArticleDeCommande(page, size);
//	}
	
	@RequestMapping(value="/getArticleDeCommandeParMagasin/{idM}/{page}/{size}",method=RequestMethod.GET)
	public PageMateriel getArticleDeCommandeParMagasin(@PathVariable int idM ,@PathVariable int page,@PathVariable int size) {
		//System.out.println(pS.findAll(page, size).toString());
		
		return pS.getArticleDeCommandeParMagasin(idM, page, size);
	}
//	
//	@RequestMapping(value="/getArticleParMagasin/{idM}/{ref}",method=RequestMethod.GET)
//	public List<Materiel> getArticleParMagasin(@PathVariable int idM ,@PathVariable String ref){
//		return pS.getArticleParMagasin(idM,ref);
//		
//	}
}
