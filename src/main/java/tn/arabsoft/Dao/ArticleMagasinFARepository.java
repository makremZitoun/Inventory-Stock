package tn.arabsoft.Dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.arabsoft.entities.ArticleMagasinFicheArticle;
import tn.arabsoft.entities.FicheArticle;
import tn.arabsoft.entities.Materiel;

public interface ArticleMagasinFARepository extends JpaRepository<ArticleMagasinFicheArticle,Integer> {


	@Query("select f.ficheArticle from ArticleMagasinFicheArticle f "
			+ "where f.materiel.id =:idA and f.magasin.id = :idM")
	public FicheArticle getFicheArticle(@Param("idA") int idA, @Param("idM") int idM);
	
	
	@Query("select a.materiel from ArticleMagasinFicheArticle a where a.magasin.id =:idM")
	public Page<Materiel> getArticleByMagasin(@Param("idM") int idM, Pageable pageable ); 
	
	@Query("select a.materiel from ArticleMagasinFicheArticle a where a.magasin.id =:idM")
	public List<Materiel> getArticleByMagasinListe(@Param("idM") int idM); 
	

	@Query("select a.materiel from ArticleMagasinFicheArticle a "
			+ "where a.magasin.id =:idM and a.materiel.sousFamille.famille.nomDeFamille =:nomF ")
	public List<Materiel> getArticleByMagasinCategorie(@Param("idM") int idM, @Param("nomF") String nomF); 
	

}
