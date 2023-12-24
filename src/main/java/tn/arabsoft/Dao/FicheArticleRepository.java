package tn.arabsoft.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import tn.arabsoft.entities.FicheArticle;

public interface FicheArticleRepository extends JpaRepository<FicheArticle,Integer> {
	
//	
	@Transactional
	@Modifying
	@Query("update FicheArticle f "
			+ "set f.stockTheorique = f.stockTheorique + :qte "
			+ "where f.id = :idFA ")
	public int updateFicheArticleE(@Param("idFA") int idFA	, @Param("qte") int qte);
//	
//		
	@Transactional
	@Modifying
	@Query("update FicheArticle f "
			+ "set f.stockTheorique = f.stockTheorique - :qte "
			+ "where f.id =:idFA ")
	public int updateFicheArticleS(@Param("idFA") int idFA , @Param("qte") int qte);
	
	@Transactional
	@Modifying
	@Query("update FicheArticle f "
			+ "set f.stockTheorique = :qte "
			+ "where f.id =:idFA ")
	public int updateStockTheorique(@Param("idFA") int idFA , @Param("qte") int qte);
	
	
	@Transactional
	@Modifying
	@Query("update FicheArticle f "
			+ "set f.stockMinimum = :sMin , f.stockSecurite = :sSec , f.stockAlerte = :sAlert "
			+ "where f.id =:idFA ")
	public int updateStockMinSecAlert(@Param("idFA") int idFA,
			@Param("sMin") int sMin,
			@Param("sSec") int sSec,
			@Param("sAlert") int sAlert);

	
	@Query("select amf.ficheArticle from ArticleMagasinFicheArticle amf"
			+ " where amf.magasin.id = :idM and amf.materiel.id = :idA ")
	public List<FicheArticle> getFicheArticleByMagasinArticle(@Param("idM") int idM , @Param("idA") int idA);
}
