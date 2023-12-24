package tn.arabsoft.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.arabsoft.Service.PlanificationIService;
import tn.arabsoft.entities.PlanificationInventaire;

@RestController
@RequestMapping(value ="/planificationInventaire")
public class PlanifcationRest implements CrudRest<PlanificationInventaire> {

	@Autowired
	private PlanificationIService pS;

	@RequestMapping(value="/save",method=RequestMethod.POST)
	@Override
	public PlanificationInventaire save(@RequestBody PlanificationInventaire t) {
		// TODO Auto-generated method stub
		return pS.save(t);
	}

	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	@Override
	public List<PlanificationInventaire> getAll() {
		// TODO Auto-generated method stub
		return pS.getAll();
	}
	@RequestMapping(value="/get/{id}",method=RequestMethod.GET)
	@Override
	public PlanificationInventaire getOne(@PathVariable int id) {
		// TODO Auto-generated method stub
		return pS.getOne(id);
	}

	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	@Override
	public int delete(@PathVariable int id) {
		// TODO Auto-generated method stub
		return pS.delete(id);
	}

//	public PlanificationInventaire getInventaieEnCours()
//	{
////		return 
//		
//	}


}
