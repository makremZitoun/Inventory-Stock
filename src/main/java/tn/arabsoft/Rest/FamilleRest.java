package tn.arabsoft.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.arabsoft.Service.FamilleService;
import tn.arabsoft.entities.Famille;
@RestController
@RequestMapping(value="/famille")
public class FamilleRest implements CrudRest<Famille>{

	@Autowired
	private	FamilleService catS ;

	@RequestMapping(value="/save",method=RequestMethod.POST)
	@Override
	public Famille save(@RequestBody Famille t) {
		// TODO Auto-generated method stub
		return catS.save(t);
	}

	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	@Override
	public List<Famille> getAll() {
		// TODO Auto-generated method stub
		return catS.getAll();
	}
	@RequestMapping(value="/get/{id}",method=RequestMethod.GET)
	@Override
	public Famille getOne(@PathVariable int id) {
		// TODO Auto-generated method stub
		return catS.getOne(id);
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	@Override
	public int delete(@PathVariable	int id) {
		// TODO Auto-generated method stub
		return catS.delete(id);
	}
	
}
