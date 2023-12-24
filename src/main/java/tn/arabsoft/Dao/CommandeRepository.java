package tn.arabsoft.Dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import tn.arabsoft.entities.Commande;
import tn.arabsoft.entities.Etat;

public interface CommandeRepository extends JpaRepository<Commande,Integer> {


	@Query("select c from Commande c where c.magasin.id = :idM and c.typeCommande = 'AI' ORDER BY c.dateCommande DESC")
	public Page<Commande> getCommandeParMagasin(@Param("idM") int idU , Pageable pageable);


	@Query("select c from Commande c where c.utilisateur.id = :idU and c.typeCommande = 'AI' ORDER BY c.dateCommande DESC")
	public Page<Commande> getCommandeParUtilisateur(@Param("idU") Long idU , Pageable pageable);


	@Transactional
	@Modifying
	@Query("update Commande c set c.etat = :etatC where c.id = :idC")
	public int updateEtatCommande(@Param("etatC")Etat etatC , @Param("idC") int idC);


	//	
	@Query("select c from Commande c where c.magasin.id = :idM and c.etat = :etatC and c.typeCommande = 'AI' ORDER BY c.dateCommande DESC")
	public Page<Commande> getCommandeParMagasinEtat(@Param("idM") int idM , @Param("etatC") Etat etatC,  Pageable pageable);

	//	
	@Query("select c from Commande c where c.utilisateur.magasin.id = :idM and c.etat = :etatC and c.typeCommande = 'AI' ORDER BY c.dateCommande DESC")
	public Page<Commande> getCommandeParMagasinUtilisateurEtat(@Param("idM") int idM , @Param("etatC") Etat etatC,  Pageable pageable);

	@Query("select c from Commande c where c.magasin.id = :idM and c.etat = :etatC and c.typeCommande = 'D' ORDER BY c.dateCommande DESC")
	public Page<Commande> getDemande(@Param("idM") int idM , @Param("etatC") Etat etatC,  Pageable pageable);

	@Query("select c from Commande c where c.magasin.id = :idM and c.etat = :etatC and c.typeCommande = 'D' ORDER BY c.dateCommande DESC")
	public Page<Commande> getDemandeParMagasinEtat(@Param("idM") int idM , @Param("etatC") Etat etatC,  Pageable pageable);




}
