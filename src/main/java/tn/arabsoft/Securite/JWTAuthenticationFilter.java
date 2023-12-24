package tn.arabsoft.Securite;

import java.io.IOException;
import java.util.Date;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import tn.arabsoft.entities.Utilisateur;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

	private AuthenticationManager authenticationManager ;

	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		Utilisateur  appUser =null ;	
		/*utiliser lors les données	sont envoyees en format  WWWURLENCODER
		String username = request.getParameter("username") ;*/
		try {
			//Deserialisation de l objet USER lors la tentative de authentification
			appUser = new ObjectMapper().readValue(request.getInputStream(),Utilisateur.class);
		} catch (IOException e) {
			throw	new RuntimeException(e);
		}
//		System.out.println("****************");
//		System.out.println("USERNAME=>	"+appUser.getUserName());
//		System.out.println("PASSWORD=>	"+appUser.getPassword());
//		
		String nom = authenticationManager.
				authenticate(new UsernamePasswordAuthenticationToken(appUser.getUserName(), appUser.getPassword())).getName() ;
				
		System.out.println(
				nom
				);
		
		return	authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(appUser.getUserName(), appUser.getPassword())
				);

	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		User springUser = (User) authResult.getPrincipal();
		String jwt = Jwts.builder()
				.setSubject(springUser.getUsername())
				.setExpiration(new Date(System.currentTimeMillis()+SecurityConstants.EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS256, SecurityConstants.SECRET)
				.claim("roles",springUser.getAuthorities())
				.compact() ;
		response.addHeader(SecurityConstants.HEADER_STRING,SecurityConstants.TOKEN_PREFIX+jwt);
	}

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		super();
		this.authenticationManager = authenticationManager;
	}





}
