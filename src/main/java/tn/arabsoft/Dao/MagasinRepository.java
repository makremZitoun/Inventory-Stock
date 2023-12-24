package tn.arabsoft.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.arabsoft.entities.Magasin;

public interface MagasinRepository extends JpaRepository<Magasin,Integer> {
	
	@Query("select m from Magasin m  where  m.typeMagasin like 'fournisseur'")
	public List<Magasin> getMagasinFournisseur();
	
	@Query("select m from Magasin m  where  m.typeMagasin like 'client'")
	public List<Magasin> getMagasinClient();

}
