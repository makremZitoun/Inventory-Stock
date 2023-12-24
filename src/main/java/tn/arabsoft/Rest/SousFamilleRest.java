package tn.arabsoft.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tn.arabsoft.Service.SousFamilleIService;
import tn.arabsoft.entities.SousFamille;

@RestController
@RequestMapping(value ="/sousFamille")
public class SousFamilleRest implements CrudRest<SousFamille> {

	@Autowired
	private SousFamilleIService scR ;
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@Override
	public SousFamille save(SousFamille t) {
		// TODO Auto-generated method stub
		return scR.save(t);
	}

	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	@Override
	public List<SousFamille> getAll() {
		// TODO Auto-generated method stub
		return scR.getAll();
	}

	@Override
	public SousFamille getOne(int id) {
		// TODO Auto-generated method stub
		return scR.getOne(id);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		scR.delete(id);
		return id;
	}
	
	@RequestMapping(value="getsousFamilleByNom/{nomSC}",method=RequestMethod.GET)
	public SousFamille getSousCategorieByNom(@PathVariable String nomSC) {
		return scR.getSousFamilleByNom(nomSC);
	}

	@RequestMapping(value="getsousFamilleByNomFamille/{nomC}",method=RequestMethod.GET)
	public List<SousFamille> getSousCategorieByNomCategorie(@PathVariable String nomC) {
		return scR.getsousFamilleBynomFamille(nomC);
	}
	
}
