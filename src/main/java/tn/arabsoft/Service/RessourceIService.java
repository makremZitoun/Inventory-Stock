package tn.arabsoft.Service;

import java.util.List;

import tn.arabsoft.entities.Equipe;
import tn.arabsoft.entities.Ressource;
import tn.arabsoft.entities.Utilisateur;

public interface RessourceIService extends CrudService<Ressource>{

	public List <Utilisateur> getListUtilisateurParEquipe(int idE);
	public Equipe getEquipeParUtilisateur(Long idU);
	
}
