package tn.arabsoft.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import tn.arabsoft.entities.ArticleApprouve;
import tn.arabsoft.entities.ArticleQuantite;
import tn.arabsoft.entities.CommandeArticle;
import tn.arabsoft.entities.Etat;

public interface CommandeArticleRepository extends JpaRepository<CommandeArticle,Integer>{

	
	@Query("select new tn.arabsoft.entities.ArticleQuantite(c.materiel,c.qteCommande)"
			+ "from CommandeArticle c "
			+ "where c.commande.id = :idC ")
	public List<ArticleQuantite> getArticleDeCommande(@Param("idC") int idC);
	
	
	@Query("select new tn.arabsoft.entities.ArticleApprouve(c.materiel,SUM(c.qteApprouve)) "
			+ "from CommandeArticle c "
			+ "where c.materiel.id = :idC and c.commande.etat = 'Approuve' ")
	public List<ArticleApprouve> getArticleApprouve(@Param("idC") int idC);
	
	
	@Transactional
	@Modifying
	@Query("update CommandeArticle c set c.qteApprouve  = :qte where c.commande.id = :idC and c.materiel.id = :idA")
	public int updateQteApprouve(@Param("idC") int idC ,@Param("idA") int idA , @Param("qte") int qte);
	

	@Transactional
	@Modifying
	@Query("update CommandeArticle c set c.qteFournie  = :qte where c.commande.id = :idC and c.materiel.id = :idA")
	public int updateQteFournie(@Param("idC") int idC ,@Param("idA") int idA , @Param("qte") int qte);
	
	
	
	@Query("select c from CommandeArticle c where c.commande.etat = :etatC and c.commande.id = :idC and c.commande.typeCommande = 'AI' ")
    public List<CommandeArticle> getCommandeArticleByEtat(@Param("etatC")Etat etatC ,@Param("idC")int idC);


	@Query("select c "
			+ "from CommandeArticle c "
			+ "where  c.commande.id = :idC ")
	public List<CommandeArticle> getArticleApprouveCmd(@Param("idC") int idC);
	
}
