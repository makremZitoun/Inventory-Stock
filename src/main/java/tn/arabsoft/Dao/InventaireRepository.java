package tn.arabsoft.Dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import tn.arabsoft.entities.Etat;
import tn.arabsoft.entities.EtatInv;
import tn.arabsoft.entities.Inventaire;

public interface InventaireRepository extends JpaRepository<Inventaire,Integer> {

	@Transactional
	@Modifying	
	@Query("update Inventaire i set i.etat = :etatI  where i.idI = :idI")
	public int updateEtatInventaire(@Param("etatI") EtatInv etatI, @Param("idI") int idI);
	
	@Transactional
	@Modifying	
	@Query("update Inventaire i set i.dateInventaire1 = :dateI  where i.idI = :idI")
	public int updatedate2Inventaire(@Param("dateI") Date dateI, @Param("idI") int idI);
	
	
	@Query("select i from Inventaire i where etat like 'terminer' ORDER BY i.dateInventaire DESC ")
	public List<Inventaire> getEtatByEtatTerminer();
	
}
