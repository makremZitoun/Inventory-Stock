package tn.arabsoft.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.arabsoft.entities.Equipe;
import tn.arabsoft.entities.Ressource;
import tn.arabsoft.entities.Utilisateur;

public interface RessourceRepository extends JpaRepository<Ressource,Integer> {
	
	@Query("select r.utilisateur from Ressource r where r.equipe.id = :idE ")
	public List <Utilisateur> getListUtilisateurParEquipe(@Param("idE") int idE);
	
	@Query("select r.equipe from Ressource r where r.utilisateur.id = :idU")
	public Equipe getEquipeParUtilisateur(@Param("idU") Long idU);

}
