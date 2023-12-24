package tn.arabsoft.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.arabsoft.Service.CompteIService;
import tn.arabsoft.entities.RegisterForm;
import tn.arabsoft.entities.Utilisateur;

@RestController
@RequestMapping(value="/compte")
public class CompteRest   {

	@Autowired	
	private CompteIService compteIservice ;
	
	@Autowired
	private org.springframework.security.core.userdetails.UserDetailsService uDS;

	@PostMapping("/register")
	public Utilisateur register(@RequestBody RegisterForm userForm)
	{
		if(! userForm.getPassword().equals(userForm.getRepassword()))throw new RuntimeException("Password Inconfirmé");
		Utilisateur user = compteIservice.findUserByUserName(userForm.getUsername());
		if(user!=null) throw new RuntimeException("Utilisateur Déja Existé");
		Utilisateur appUser = new Utilisateur() ; 
		appUser.setUserName(userForm.getUsername());
		appUser.setPassword(userForm.getPassword());
		compteIservice.saveU(appUser);
		compteIservice.addRoleToUser(userForm.getUsername(),"USER");
		return appUser ;	}
	
	@RequestMapping(value="/getUser1/{username}",method=RequestMethod.GET)
	public UserDetails getUser1(@PathVariable	String username) {
		// TODO Auto-generated method stub
		return uDS.loadUserByUsername(username);
	}
	@RequestMapping(value="/getUser2/{username}",method=RequestMethod.GET)
	public Utilisateur getUser2(@PathVariable	String username) {
		// TODO Auto-generated method stub
		return compteIservice.findUserByUserName(username) ;
	}
	
	@RequestMapping(value="/getUsersOfMagasin/{idM}",method=RequestMethod.GET)
	public List<Utilisateur> getUsersOfMagasin(@PathVariable int idM) {
		return compteIservice.getUsersByMagasin(idM);
	}
	

	
	
}
