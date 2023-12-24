package tn.arabsoft.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.arabsoft.Service.CommandeIService;
import tn.arabsoft.entities.Commande;
import tn.arabsoft.entities.Etat;
import tn.arabsoft.entities.PageCommnande;

@RestController
@RequestMapping(value ="/commande")
public class CommandeRest implements CrudRest<Commande> {
	
	@Autowired
	public CommandeIService cS;

	@RequestMapping(value="/save",method=RequestMethod.POST)
	@Override
	public Commande save(@RequestBody Commande t) {
		// TODO Auto-generated method stub
		return cS.save(t);
	}

	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	@Override
	public List<Commande> getAll() {
		// TODO Auto-generated method stub
		return cS.getAll();
	}

	@RequestMapping(value="/get/{id}",method=RequestMethod.GET)
	@Override
	public Commande getOne(int id) {
		// TODO Auto-generated method stub
		return cS.getOne(id);
	}

	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return cS.delete(id);
	}
	
	
	@RequestMapping(value="/getcommandeparmagasin/{idM}/{page}/{size}",method=RequestMethod.GET)
	public PageCommnande getAllPagination(@PathVariable int idM,@PathVariable int page,@PathVariable int size) {
		//System.out.println(pS.findAll(page, size).toString());
		
		return cS.getCommandeParMagasin(idM, page, size);
	}
	
	
	
	@RequestMapping(value="/getcommandeparutilisateur/{idM}/{page}/{size}",method=RequestMethod.GET)
	public PageCommnande getCommandeParUtilisateur(@PathVariable Long idM,@PathVariable int page,@PathVariable int size) {
		//System.out.println(pS.findAll(page, size).toString());
		
		return cS.getCommandeParUtilisateur(idM, page, size);
	}
	
	@RequestMapping(value="/updateEtatCommande/{etatC}/{idC}",method=RequestMethod.PUT)
	public Commande updateEtatCommande(@PathVariable Etat etatC ,@PathVariable int idC) {
		 return cS.updateEtatCommande(etatC, idC);
		 
	}
	
	@RequestMapping(value="/getcommandeparmagasinetat/{idM}/{etatC}/{page}/{size}",method=RequestMethod.GET)
	public PageCommnande getcommandeparmagasinetat(@PathVariable int idM,@PathVariable Etat etatC,	@PathVariable int page,@PathVariable int size) {
		//System.out.println(pS.findAll(page, size).toString());
		
		return cS.getCommandeParMagasinEtat(idM, etatC, page, size);
	}

	@RequestMapping(value="/getCommandeParMagasinUtilisateurEtat/{idM}/{etatC}/{page}/{size}",method=RequestMethod.GET)
	public PageCommnande getCommandeParMagasinUtilisateurEtat(@PathVariable int idM,@PathVariable Etat etatC,	@PathVariable int page,@PathVariable int size) {
		//System.out.println(pS.findAll(page, size).toString());
		
		return cS.getCommandeParMagasinUtilisateurEtat(idM, etatC, page, size);
	}
	
	@RequestMapping(value="/getDemande/{idM}/{etatC}/{page}/{size}",method=RequestMethod.GET)
	public PageCommnande getDemande(@PathVariable int idM,@PathVariable Etat etatC,	@PathVariable int page,@PathVariable int size) {
		//System.out.println(pS.findAll(page, size).toString());
		
		return cS.getDemande(idM, etatC, page, size);
	}
	
	@RequestMapping(value="/getDemandeparmagasinetat/{idM}/{etatC}/{page}/{size}",method=RequestMethod.GET)
	public PageCommnande getDemandeparmagasinetat(@PathVariable int idM,@PathVariable Etat etatC,	@PathVariable int page,@PathVariable int size) {
		//System.out.println(pS.findAll(page, size).toString());
		
		return cS.getDemandeParMagasinEtat(idM, etatC, page, size);
	}
}
