package tn.arabsoft.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.arabsoft.entities.Role;

public interface RoleRepository  extends JpaRepository<Role,Long>{
//	@Query("select o from Role o where o.roleName=:roleName") @Param("x")
	public Role findByRoleName( String roleName);
 
	

}
