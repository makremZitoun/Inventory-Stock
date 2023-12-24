package tn.arabsoft.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.arabsoft.Service.AbsenceIService;
import tn.arabsoft.entities.Absence;

@RestController
@RequestMapping(value="/absence" )
public class AbsenceRest implements CrudRest<Absence> {

	@Autowired
	private AbsenceIService aS;
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@Override
	public Absence save(@RequestBody Absence t) {
		// TODO Auto-generated method stub
		return aS.save(t);
	}

	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	@Override
	public List<Absence> getAll() {
		// TODO Auto-generated method stub
		return aS.getAll();
	}

	@RequestMapping(value="/get/{id}",method=RequestMethod.GET)
	@Override
	public Absence getOne(@PathVariable int id) {
		// TODO Auto-generated method stub
		return aS.getOne(id);
	}

	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	@Override
	public int delete(@PathVariable int id) {
		// TODO Auto-generated method stub
		return aS.delete(id);
	}

}
