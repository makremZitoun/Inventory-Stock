package tn.arabsoft.Dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.arabsoft.entities.FicheStock;
import tn.arabsoft.entities.MvCmdDelai;

public interface FicheStockRepository extends JpaRepository<FicheStock,Integer>{

	
	@Query("select fs from FicheStock fs where mouvmentDeStock.id=:id")
	public Page<FicheStock> findFSbyMouvmemnt(@Param("id") int id , Pageable pageable);
	
	@Query("select fs from FicheStock fs where fs.materiel.id = :idA and"
			+ " type = 'E' and "
			+ "fs.mouvmentDeStock.etat = 'Execute' and "
			+ "fs.mouvmentDeStock.Utilisateur.magasin.id = :idM "
			+ "ORDER BY fs.mouvmentDeStock.dateMouvement DESC")
	public Page<FicheStock> getFSByArticle(@Param("idA") int idA ,@Param("idM") int idM , Pageable pageable);
	
	
	@Query("select fs from FicheStock fs where fs.materiel.id = :idA and "
			+ "fs.mouvmentDeStock.Utilisateur.magasin.id = :idM "
			+ "and DATE_FORMAT(fs.mouvmentDeStock.dateMouvement,'%Y-%m-%d') between :dateD and :dateF "
			+ "and type = 'S' "
			+ "and fs.mouvmentDeStock.etat = 'Execute' "
			+ "ORDER BY fs.mouvmentDeStock.dateMouvement DESC")
//			+ "and typeSortie = 'Sortie Directe")
	public List<FicheStock> getFSByIntervalle(@Param("idA") int idA ,@Param("idM") int idM , @Param("dateD") String dateD, @Param("dateF") String dateF );

	@Query("select fs from FicheStock fs where fs.materiel.id = :idA and"
			+ " type = 'S' and "
			+ "fs.mouvmentDeStock.etat = 'Execute' and "
			+ "fs.mouvmentDeStock.Utilisateur.magasin.id = :idM "
			+ "ORDER BY fs.mouvmentDeStock.dateMouvement DESC")
	public Page<FicheStock> getFSByArticleS(@Param("idA") int idA ,@Param("idM") int idM , Pageable pageable);
	
	@Query("select fs from FicheStock fs where fs.materiel.id = :idA and "			
			+ "fs.mouvmentDeStock.etat = 'Execute' and "
			+ "fs.mouvmentDeStock.Utilisateur.magasin.id = :idM "
			+ "ORDER BY fs.mouvmentDeStock.dateMouvement DESC")
	public Page<FicheStock> getFSByArticleA(@Param("idA") int idA ,@Param("idM") int idM , Pageable pageable);
	
	@Query("select new tn.arabsoft.entities.MvCmdDelai( "
			+ "fs.mouvmentDeStock , fs.mouvmentDeStock.commande, fs.materiel, "
			+ "Hour(TIMEDIFF(fs.mouvmentDeStock.dateMouvement ,fs.mouvmentDeStock.commande.dateCommande)),"
			+ "Minute(TIMEDIFF(fs.mouvmentDeStock.dateMouvement ,fs.mouvmentDeStock.commande.dateCommande)), "
			+ "Second(TIMEDIFF(fs.mouvmentDeStock.dateMouvement ,fs.mouvmentDeStock.commande.dateCommande))) "
			+ "from FicheStock fs "
			+ "where fs.mouvmentDeStock.etat = 'Execute' and fs.mouvmentDeStock.typeEntree='ApprovisionnementInterne' "
			+ "and fs.mouvmentDeStock.Utilisateur.magasin.id = :idM and fs.materiel.id =:idA "
			+ "ORDER BY fs.mouvmentDeStock.dateMouvement DESC")
	public Page<MvCmdDelai> getMvCmdDelai(@Param("idA") int idA,@Param("idM") int idM, Pageable pageable);
	
	@Query("Select fs from FicheStock fs where fs.mouvmentDeStock.id = :idMv ")
	public List<FicheStock> getFicheStockByMouvement(@Param("idMv") int idMv);
	
	
}
