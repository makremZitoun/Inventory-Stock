package tn.arabsoft.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.arabsoft.entities.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe,Integer> {

//	@Query("select e FROM Equipe e LEFT JOIN e.listplannifcation p where p.equipe = null "
//			+ "or ( DATE_FORMAT(p.dateFin,'%Y-%m-%d') < :dateSouhaite and p.inventaire.etat = 'traite') ")
//	public List<Equipe> getEquipeDiponible(@Param("dateSouhaite") String dateD);
	
}
