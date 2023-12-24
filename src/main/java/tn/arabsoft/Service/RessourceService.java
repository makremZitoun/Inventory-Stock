package tn.arabsoft.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.arabsoft.Dao.RessourceRepository;
import tn.arabsoft.entities.Equipe;
import tn.arabsoft.entities.Ressource;
import tn.arabsoft.entities.Utilisateur;

@Service
public class RessourceService implements RessourceIService {

	@Autowired
	private RessourceRepository rR;
	
	@Override
	public Ressource save(Ressource t) {
		// TODO Auto-generated method stub
		return rR.save(t);
	}

	@Override
	public List<Ressource> getAll() {
		// TODO Auto-generated method stub
		return rR.findAll();
	}

	@Override
	public Ressource getOne(int id) {
		// TODO Auto-generated method stub
		return rR.findById(id).get();
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		rR.deleteById(id);
		return id;
	}

	public RessourceService(RessourceRepository rR) {
		super();
		this.rR = rR;
	}

	public RessourceService() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<Utilisateur> getListUtilisateurParEquipe(int idE) {
		// TODO Auto-generated method stub
		return this.rR.getListUtilisateurParEquipe(idE);
	}

	@Override
	public Equipe getEquipeParUtilisateur(Long idU) {
		// TODO Auto-generated method stub
		return this.rR.getEquipeParUtilisateur(idU);
	}
	
}
