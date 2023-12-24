package tn.arabsoft.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.arabsoft.entities.PlanificationInventaire;

public interface PlanificationRepository extends JpaRepository<PlanificationInventaire,Integer>
{
	
//	@Query("select p from PlanificationInventaire p where p.equipe.id = :idE and p.inventaire.etat = 'encours'")
//	public PlanificationInventaire getInventaieEnCours(@Param("idE") int idE);

}
