package tn.arabsoft.Dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import tn.arabsoft.entities.Materiel;
import tn.arabsoft.entities.SousFamille;

public interface MaterielRepository extends JpaRepository<Materiel,Integer>   {
    @Query("select a from ArticleMagasinFicheArticle a where a.magasin.id = :idM")
	public Page<Materiel> findAll(@Param("idM")int idM , Pageable pageable);
	
	public Materiel findByCodeABarre (String code) ;
	@Transactional
	@Modifying
	@Query("update Materiel p set p.sousFamille =:sc where  p.id =:id")
   public int setCategorie(@Param("sc") SousFamille sc , @Param("id") int id ) ;
	
	@Query("select a from Materiel a where a.ref like %:ref%")
	public List<Materiel> getByRef(@Param("ref")String ref);
	
	
//	@Query("select a from Materiel a where a.ficheArticle.stockTheorique <= a.ficheArticle.stockAlerte")
//	public Page<Materiel> getArticleDeCommande(Pageable pageable);
//	
	@Query("select a from ArticleMagasinFicheArticle a"
			+ " where a.ficheArticle.stockTheorique <= a.ficheArticle.stockAlerte"
			+ " and a.magasin.id = :idM")
	public Page<Materiel> getArticleDeCommandeParMagasin(@Param("idM") int idM ,Pageable pageable);
//	
//	
//	@Query("select a from Materiel a where a.magasin.id = :idM and a.ref = :ref")
//	public List<Materiel> getArticleParMagasin(@Param("idM") int idM ,@Param("ref") String ref);
//	
//	
}
