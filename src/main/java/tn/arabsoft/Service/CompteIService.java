package tn.arabsoft.Service;

import java.util.List;
import tn.arabsoft.entities.Role;
import tn.arabsoft.entities.Utilisateur;

public interface CompteIService  {

	public void addRoleToUser(String username , String rolename) ;
	public Utilisateur saveU(Utilisateur t);
	public Role saveR(Role t);
	public Utilisateur findUserByUserName(String username) ;
	public List<Utilisateur> getUsersByMagasin(int id);

}
