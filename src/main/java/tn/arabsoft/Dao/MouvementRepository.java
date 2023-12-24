package tn.arabsoft.Dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import tn.arabsoft.entities.Document;
import tn.arabsoft.entities.Etat;
import tn.arabsoft.entities.MouvementDate;
import tn.arabsoft.entities.MouvementDeStock;
import tn.arabsoft.entities.MouvementUtilisateur;
import tn.arabsoft.entities.MvGroupByEtat;
import tn.arabsoft.entities.MvGroupByUserAndEtat;

public interface MouvementRepository extends JpaRepository<MouvementDeStock, Integer>{

	
	@Query("select count(*) from MouvementDeStock m where type='E'")
	public int getNbMouvement();
	
	@Query("select count(*) from MouvementDeStock m where type='S'")
	public int getNbSortie();
	
	@Query("select new tn.arabsoft.entities.MvGroupByUserAndEtat(m.Utilisateur.userName,m.etat,count(m)) from MouvementDeStock m Group By m.Utilisateur , m.etat")
	public List<MvGroupByUserAndEtat> getNbMouvementByUser_Etat();

	@Query("select new tn.arabsoft.entities.MvGroupByEtat(m.etat,count(m)) from MouvementDeStock m Group By m.etat")
	public List<MvGroupByEtat> getNBMouvmentByEtat();
	

	@Query("select m from MouvementDeStock m where etat=:etatM")
	public List<MouvementDeStock> getMouvementByEtat(@Param("etatM") Etat etatM );
	
	@Query("select m from MouvementDeStock m where etat=:etatM ORDER BY m.dateMouvement DESC")
	public Page<MouvementDeStock> getPageMouvementByEtat(@Param("etatM") Etat etaM , Pageable pageable);
	
	/**********ENTREE*************/

	@Query("select new tn.arabsoft.entities.MouvementDate("
			+ " m , "
			+ "Hour(TIMEDIFF(now(),dateMouvement)),"
			+ "Minute(TIMEDIFF(now(),dateMouvement)),"
			+ "Second(TIMEDIFF(now(),dateMouvement))) "
			+ "from MouvementDeStock m "
			+ "where etat=:etatM and type='E' and m.Utilisateur.magasin.id = :idM "
			+ "ORDER BY m.dateMouvement DESC")
	public Page<MouvementDate> getMouvementByEtatDuree(@Param("etatM") Etat etaM, @Param("idM") int idM, Pageable pageable);
	
	@Query("select new tn.arabsoft.entities.MouvementDate("
			+ " m , "
			+ "Hour(TIMEDIFF(now(),dateMouvement)), "
			+ "Minute(TIMEDIFF(now(),dateMouvement)), "
			+ "Second(TIMEDIFF(now(),dateMouvement))) "
			+ "from MouvementDeStock m where "
			+ "typeEntree= :typeE and type='E' and m.Utilisateur.magasin.id = :idM "
			+ "ORDER BY m.dateMouvement DESC")
	public Page<MouvementDate> getMouvementByTypeDuree(@Param("typeE") String typeE, @Param("idM") int idM, Pageable pageable);
	
	@Query("select new tn.arabsoft.entities.MouvementDate("
			+ " m , "
			+ "Hour(TIMEDIFF(now(),dateMouvement)), "
			+ "Minute(TIMEDIFF(now(),dateMouvement)), "
			+ "Second(TIMEDIFF(now(),dateMouvement))) "
			+ "from MouvementDeStock m  "
			+ "where DATE_FORMAT(dateMouvement,'%Y-%m-%d') = :dateM and type='E' and m.Utilisateur.magasin.id = :idM "
			+ "ORDER BY m.dateMouvement DESC")
	public Page<MouvementDate> getMouvementByDateDuree(@Param("dateM") String dateM , @Param("idM") int idM,Pageable pageable);
	
	/*********SORTIE**************/
	@Query("select new tn.arabsoft.entities.MouvementDate("
			+ " m , "
			+ "Hour(TIMEDIFF(now(),dateMouvement)),"
			+ "Minute(TIMEDIFF(now(),dateMouvement)),"
			+ "Second(TIMEDIFF(now(),dateMouvement))) "
			+ "from MouvementDeStock m "
			+ "where etat=:etatM and type='S' and m.Utilisateur.magasin.id = :idM "
			+ "ORDER BY m.dateMouvement DESC")
	public Page<MouvementDate> getSortieByEtatDuree(@Param("etatM") Etat etaM, @Param("idM") int idM, Pageable pageable);
	
	@Query("select new tn.arabsoft.entities.MouvementDate("
			+ " m , "
			+ "Hour(TIMEDIFF(now(),dateMouvement)), "
			+ "Minute(TIMEDIFF(now(),dateMouvement)), "
			+ "Second(TIMEDIFF(now(),dateMouvement))) "
			+ "from MouvementDeStock m where "
			+ "typeSortie= :typeE and type='S' and m.Utilisateur.magasin.id = :idM "
			+ "ORDER BY m.dateMouvement DESC")
	public Page<MouvementDate> getSortieByTypeDuree(@Param("typeE") String typeE, @Param("idM") int idM, Pageable pageable);
	
	@Query("select new tn.arabsoft.entities.MouvementDate("
			+ " m , "
			+ "Hour(TIMEDIFF(now(),dateMouvement)), "
			+ "Minute(TIMEDIFF(now(),dateMouvement)), "
			+ "Second(TIMEDIFF(now(),dateMouvement))) "
			+ "from MouvementDeStock m  "
			+ "where DATE_FORMAT(dateMouvement,'%Y-%m-%d') = :dateM and type='S' and m.Utilisateur.magasin.id = :idM "
			+ "ORDER BY m.dateMouvement DESC")
	public Page<MouvementDate> getSortieByDateDuree(@Param("dateM") String dateM , @Param("idM") int idM,Pageable pageable);
	
	
	/*****************************/
	
	@Transactional
	@Modifying	
	@Query("update MouvementDeStock m set m.etat =:etatM  where m.id =:id")
	public int updateEtatMouvemnt(@Param("etatM")Etat etatM , @Param("id") int id);
	
	@Transactional
	@Modifying	
	@Query("update MouvementDeStock m set m.document =:d where m.id =:id")
	public int updateDocumentMouvemnt(@Param("d") Document d , @Param("id") int id);
	

	@Query("select new tn.arabsoft.entities.MouvementUtilisateur("
			+ " m , Hour(TIMEDIFF(now(),dateMouvement))-1,Minute(TIMEDIFF(now(),dateMouvement)),Second(TIMEDIFF(now(),dateMouvement)) "
			+ ") from MouvementDeStock m where m.Utilisateur.userName =:username and ( m.etat='EnCoursDeSaisie' or m.etat='ValidePourExecution') ORDER BY m.dateMouvement DESC")
	public Page<MouvementUtilisateur> getMouvementByUtilisateur(@Param("username") String username ,Pageable pageable);
	
}
