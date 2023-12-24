package tn.arabsoft.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.arabsoft.Dao.RoleRepository;
import tn.arabsoft.entities.Role;

@Service
public class RoleService implements RoleIService {

	@Autowired
	private RoleRepository roleRepository ;
	
	@Override
	public Role findRoleByRoleName(String roleName) {
		// TODO Auto-generated method stub
		return roleRepository.findByRoleName(roleName);
	}

}
