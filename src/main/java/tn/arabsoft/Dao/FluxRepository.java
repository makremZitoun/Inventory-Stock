package tn.arabsoft.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.arabsoft.entities.Flux;

public interface FluxRepository extends JpaRepository<Flux, Integer> {
	
	@Query("select f from Flux f where f.inventaireID.idI = :idI")
	public List<Flux> getFluxChargementUtilisateur(@Param("idI") int idI);
	

	@Query("select f from Flux f where f.inventaireID.idI = :idInv and f.utilisateur.id = :idU and f.description LIKE 'C'")
	public Flux getFluxByUserInv(@Param("idU") Long idU,@Param("idInv") int idInv);
	
	@Query("select f from Flux f where f.inventaireID.idI = :idInv and f.utilisateur.id = :idU and f.description LIKE 'C2'")
	public Flux getFluxDeuxCmpByUserInv(@Param("idU") Long idU,@Param("idInv") int idInv);

}
