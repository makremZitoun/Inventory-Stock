package tn.arabsoft.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.arabsoft.entities.SousFamille;


public interface SousFamilleRepository extends JpaRepository<SousFamille,Integer>{

	@Query("select o from SousFamille o where o.nomDeSousFamille=:x")
	public SousFamille getSousFamilleByNom(@Param("x")String nomCategorie);
	
	
	@Query("select sc FROM SousFamille sc where famille.nomDeFamille =:x")
	public List<SousFamille> getsousFamilleBynomFamille(@Param("x") String nomCategorie);
	
}
