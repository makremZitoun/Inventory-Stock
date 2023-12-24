package tn.arabsoft.Service;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tn.arabsoft.entities.Utilisateur;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{



	@Autowired
	private CompteIService compteSerive ;
	
	


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Utilisateur user = compteSerive.findUserByUserName(username) ;
		if(user	== null) throw new UsernameNotFoundException(username);
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		user.getRoles().forEach(
				r -> {authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
				}
				);
		return new  User(user.getUserName(),user.getPassword(),authorities);
	}
	
 

}
