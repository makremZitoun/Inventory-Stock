package tn.arabsoft.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.arabsoft.Dao.RoleRepository;
import tn.arabsoft.Dao.UserRepository;
import tn.arabsoft.entities.Role;
import tn.arabsoft.entities.Utilisateur;
@Service
@Transactional
public class CompteService  implements CompteIService{
	@Autowired
	private UserRepository userR ;

	@Autowired
	private BCryptPasswordEncoder bcpe ; 
	@Autowired
	private RoleRepository roleR ;

	@Override
	public void addRoleToUser(String username, String rolename) {
		Utilisateur user = 	userR.findByUserName(username) ;//this.findUserByUserName(username);
		Role role = roleR.findByRoleName(rolename) ;
		user.getRoles().add(role);		
	}
	@Override
	public Utilisateur saveU(Utilisateur t) {
		String hashPWD = bcpe.encode(t.getPassword());
		t.setPassword(hashPWD);
		return userR.save(t);
	}
	@Override
	public Role saveR(Role t) {
		// TODO Auto-generated method stub
		return roleR.save(t);

	}

	@Override
	public Utilisateur findUserByUserName(String username) {
		// TODO Auto-generated method stub
		return userR.findByUserName(username);
	}
	@Override
	public List<Utilisateur> getUsersByMagasin(int idM) {
		// TODO Auto-generated method stub
		return userR.getUsersByMagasin(idM);
	}




}
