package tn.arabsoft.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.arabsoft.Service.EquipeIService;
import tn.arabsoft.entities.Equipe;

@RestController
@RequestMapping(value="/equipe" )
public class EquipeRest implements CrudRest<Equipe>{
		
	@Autowired
	private EquipeIService eS;
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@Override
	public Equipe save(@RequestBody Equipe t) {
		// TODO Auto-generated method stub
		return eS.save(t);
	}

	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	@Override
	public List<Equipe> getAll() {
		// TODO Auto-generated method stub
		return eS.getAll();
	}

	@RequestMapping(value="/get/{id}",method=RequestMethod.GET)
	@Override
	public Equipe getOne(@PathVariable int id) {
		// TODO Auto-generated method stub
		return eS.getOne(id);
	}

	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	@Override
	public int delete(@PathVariable int id) {
		// TODO Auto-generated method stub
		return eS.delete(id);
	}
	
//	@RequestMapping(value="/getEquipeDiponible/{dateD}",method=RequestMethod.GET)
//	public List<Equipe> getEquipeDiponible(@PathVariable String dateD){
//		return eS.getEquipeDiponible(dateD);
//		
//	}

}
