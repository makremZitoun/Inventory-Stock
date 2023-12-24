 package tn.arabsoft.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.arabsoft.entities.Utilisateur;

public interface UserRepository extends JpaRepository<Utilisateur,Long> {

	public Utilisateur findByUserName(String username);
	
	@Query("select u from Utilisateur u LEFT JOIN u.roles r where u.magasin.id = :idM and r.roleName = 'ROLE_MAGASINIER'")
	public List<Utilisateur> getUsersByMagasin (@Param("idM") int idM); 


}
