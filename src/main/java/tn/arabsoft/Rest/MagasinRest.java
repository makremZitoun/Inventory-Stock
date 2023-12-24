package tn.arabsoft.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.arabsoft.Service.MagasinIService;
import tn.arabsoft.entities.Magasin;

@RestController
@RequestMapping(value="/magasin" )
public class MagasinRest implements CrudRest<Magasin> {

	@Autowired
	private MagasinIService dS ;

	@RequestMapping(value="/save",method=RequestMethod.POST)
	@Override
	public Magasin save(@RequestBody Magasin t) {
		// TODO Auto-generated method stub
		return dS.save(t);
	}

	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	@Override
	public List<Magasin> getAll() {
		// TODO Auto-generated method stub
		return dS.getAll();
	}

	@RequestMapping(value="/get/{id}",method=RequestMethod.GET)
	@Override
	public Magasin getOne(@PathVariable	int id) {
		// TODO Auto-generated method stub
		return dS.getOne(id);
	}

	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	@Override
	public int delete(@PathVariable	int id) {
		// TODO Auto-generated method stub
		return dS.delete(id);
	}
	
	@RequestMapping(value="/getMagasinFournisseur",method=RequestMethod.GET)
	public List<Magasin> getMagasinFournisseur(){
		return dS.getMagasinFournisseur();
		
	}
	
	@RequestMapping(value="/getMagasinClient",method=RequestMethod.GET)
	public List<Magasin> getMagasinClient(){
		return dS.getMagasinClient();
		
	}

	
	
}
