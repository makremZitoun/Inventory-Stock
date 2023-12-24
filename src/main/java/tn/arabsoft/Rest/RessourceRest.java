package tn.arabsoft.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.arabsoft.Service.RessourceIService;
import tn.arabsoft.entities.Equipe;
import tn.arabsoft.entities.Ressource;
import tn.arabsoft.entities.Utilisateur;

@RestController
@RequestMapping(value="/ressource" )
public class RessourceRest implements CrudRest<Ressource> {
 
	@Autowired
	private RessourceIService rS;
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@Override
	public Ressource save(@RequestBody Ressource t) {
		// TODO Auto-generated method stub
		return rS.save(t);
	}


	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	@Override
	public List<Ressource> getAll() {
		// TODO Auto-generated method stub
		return rS.getAll();
	}

	@RequestMapping(value="/get/{id}",method=RequestMethod.GET)
	@Override
	public Ressource getOne(@PathVariable int id) {
		// TODO Auto-generated method stub
		return rS.getOne(id);
	}


	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	@Override
	public int delete(@PathVariable int id) {
		// TODO Auto-generated method stub
		return rS.delete(id);
	}
	@RequestMapping(value="/getListUtilisateurParEquipe/{idE}",method=RequestMethod.GET)
	public List <Utilisateur> getListUtilisateurParEquipe(@PathVariable int idE)
	{
		return rS.getListUtilisateurParEquipe(idE);
	}

	@RequestMapping(value="/getEquipeParUtilisateur/{idU}",method=RequestMethod.GET)
	public Equipe getEquipeParUtilisateur(@PathVariable Long idU)
	{
	return rS.getEquipeParUtilisateur(idU);	
	}

}
