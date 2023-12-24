package tn.arabsoft.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import tn.arabsoft.entities.ArticleByGroupNB;
import tn.arabsoft.entities.Comptage;
import tn.arabsoft.entities.Flux;
import tn.arabsoft.entities.Inventaire;
import tn.arabsoft.entities.Materiel;
import tn.arabsoft.entities.Utilisateur;

public interface ComptageRepository extends JpaRepository<Comptage,Integer>{
	
	@Query("select c.materiel from Comptage c where c.inventaire.etat NOT LIKE 'traite' and c.materiel.id = :idA ")
	public Materiel verifierArticleInventorie(@Param("idA") int idA);

	@Transactional
	@Modifying
	@Query("update Comptage c set c.utilisateur =:u where c.inventaire.id =:idI and c.materiel.id=:idM")
	public int updateComptageUtilisateur(@Param("u") Utilisateur u ,@Param("idI") int idI, @Param("idM") int idM);
	
	@Query("Select DISTINCT c.inventaire from Comptage c where c.inventaire.etat LIKE 'Planifiee' and c.utilisateur.id = :idU")
	public List<Inventaire> getInventaireByUser(@Param("idU") Long idU );
	
	@Query("Select count(c.materiel) from Comptage c where c.inventaire.idI = :idInv and c.utilisateur.id= :idU")
	public int getNbArticleByInventaire(@Param("idInv") int idInv, @Param("idU") Long idU);
	
	@Query("Select DISTINCT c.inventaire from Comptage c where ( c.inventaire.etat LIKE 'encours' or c.inventaire.etat LIKE 'Planifiee' or c.inventaire.etat LIKE 'terminer' ) and c.utilisateur.id = :idU")
	public List<Inventaire> getInventaireEncoursPlanifierByUser(@Param("idU") Long idU );
	
	@Query("Select c.materiel from Comptage c where c.utilisateur = :idU and c.inventaire.id= :idI ")
	public List<Materiel> getMaterielByInvUser(@Param("idU") Long idU, @Param("idI") int idI);
	
	@Query("Select new tn.arabsoft.entities.ArticleByGroupNB(c.materiel.sousFamille.famille.nomDeFamille,count(c.materiel)) from ArticleMagasinFicheArticle c  where c.magasin.id= :idM Group BY c.materiel.sousFamille.famille")
	public List<ArticleByGroupNB> getNbFamille(@Param("idM") int idM);
	
	
	@Query("select c.materiel.sousFamille.famille.nomDeFamille from ArticleMagasinFicheArticle c  where c.magasin.id= :idM and c.materiel.id = :idA")
	public String getC(@Param("idM") int idM, @Param("idM") int idA);
	
	@Transactional
	@Modifying	
	@Query("update Comptage c set c.utilisateur.id = :idU  where c.materiel.id = :idM and c.inventaire.idI = :idI")
	public int updateComptageUtilisateur1(@Param("idU") Long idU, @Param("idM") int idM, @Param("idI") int idI);
	
	@Query("select DISTINCT c.utilisateur from Comptage c where c.inventaire.idI = :idI")
	public List<Utilisateur> getUserComptage( @Param("idI") int idI); 
	
	@Query("select DISTINCT c.utilisateur from Comptage c where c.inventaire.idI = :idI and c.nbComptage = 2 ")
	public List<Utilisateur> getUserDeuxComptage( @Param("idI") int idI); 
	
	@Transactional
	@Modifying	
	@Query("update Comptage c set c.qtePhysique = :qte  "
			+ "where c.utilisateur.id = :idU "
			+ "and c.materiel.id = :idM "
			+ "and c.inventaire.idI = :idI "
			+ "and c.nbComptage = 0 ")
	public int updateQtePhyComptage(@Param("idU") Long idU, @Param("idM") int idM, @Param("idI") int idI, @Param("qte") int qte);
	
	@Transactional
	@Modifying	
	@Query("update Comptage c set c.qtePhysique = :qte  "
			+ "where c.utilisateur.id = :idU "
			+ "and c.materiel.id = :idM "
			+ "and c.inventaire.idI = :idI "
			+ "and c.nbComptage = 2 ")
	public int updateQtePhyDeuxComptage(@Param("idU") Long idU, @Param("idM") int idM, @Param("idI") int idI, @Param("qte") int qte);
	
	
	
	
	
}
