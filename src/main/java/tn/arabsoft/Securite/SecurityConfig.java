package tn.arabsoft.Securite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig	extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailService ;
	@Autowired
	private BCryptPasswordEncoder BCryptPasswordEncoder  ;
	//comment il va chercher les utilisateur et les roles
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		
		auth.userDetailsService(userDetailService)
		.passwordEncoder(BCryptPasswordEncoder);
		
//		auth.inMemoryAuthentication()
//		.withUser("admin").password("{noop}1234").roles("ADMIN","USER")
//		.and()
//		.withUser("user").password("{noop}1234").roles("USER");

		//	auth.jdbcAuthentication()
		//	.usersByUsernameQuery("select") 
		//	.authoritiesByUsernameQuery("select role")
	
	}
	//Definir les droit d'acces
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable(); //syncronise token
		//		http.formLogin().loginPage("/login") ;//formulaire authentification fournit par spring
		//http.formLogin();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.authorizeRequests().antMatchers("/login/**",
		"/compte/register/**",
		"/compte/getUser1/**",
		"/compte/getUser2/**",
		"/image/**",
		"/compte/getMagasinByUsername/**",
		"/ficheStock/getFSbyMouvment/**",
		"/materiel/getAllPagination/**" , 
		"/commandeArticle/getCommandeByEtat/**",
		"/materiel/getAll/**",
		"/commandeArticle/getArticleDeCommande/**",
		"/commande/getDemande/**",
		"/ArticleMagasin/getFA/**",
		"/magasin/getMagasinFournisseur/**","/getNbBE/**",
		"/ressource/**",
		"/equipe/**",
		"/absence/**",
		"/comptage/**",
		"/ArticleMagasin/getArticleByMagasin/**",
		"/ArticleMagasin/getArticleByMagasinListe/**",
		"/inventaire/**",
		"/compte/getUsersOfMagasin/**",
		"/flux/**",
		"/materiel/getByRef/**",
		"/api/pdf/**").permitAll();
		
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/ficheStock/getFSbyArticle/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/ficheStock/getFSbyArticleS/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/ficheStock/getFSbyArticleA/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/ficheStock/getMvCmdDelai/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/ficheStock/updateFicheArticle/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/ficheStock/getFSByIntervalle/**").hasRole("ADMIN");
		
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/famille/get/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/sousFamille/getsousFamilleByNom/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/sousFamille/getsousFamilleByNomFamille/**").hasRole("ADMIN");

		http.authorizeRequests().antMatchers(HttpMethod.GET,"/materiel/get/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/materiel/save/**").hasRole("ADMIN");
//		http.authorizeRequests().antMatchers(HttpMethod.GET,"/materiel/getByRef/**").hasRole("MAGASINIER");
//		http.authorizeRequests().antMatchers(HttpMethod.GET,"/materiel/getByRef/**").hasRole("DEMANDEUR");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/materiel/delete/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/materiel/edit/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/materiel/setSousCategorie/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/materiel/getArticleDeCommande/**").hasRole("MAGASINIER");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/materiel/getArticleDeCommandeParMagasin/**").hasRole("MAGASINIER");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/materiel/getArticleParMagasin/**").hasRole("ADMIN");

		http.authorizeRequests().antMatchers(HttpMethod.GET,"/ficheArticle/getFicheArticleByMagasinArticle/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/ficheArticle/updateFicheArticleS/**").hasRole("MAGASINIER");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/ficheArticle/updateFicheArticleS/**").hasRole("MAGASINIER");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/ficheArticle/updateStockMinSecAlert/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/ficheArticle/updateStockTheorique/**").hasRole("ADMIN");
		
		
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/mouvement/getAll/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/mouvement/getNbMouvement/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/mouvement/getNbSortie/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/mouvement/getNbMouvementByUser_Etat/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/mouvement/getNbMouvementByEtat/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/mouvement/getMouvementByEtat/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/mouvement/getPageMouvementByEtat/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/mouvement/getMouvementByEtatDuree/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/mouvement/updateEtatMouvment/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/mouvement/updateDocumentMouvment/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/mouvement/getMouvementByUtilisateur/**").hasRole("MAGASINIER");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/mouvement/getMouvementByTypeDuree/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/mouvement/getMouvementByDateDuree/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/mouvement/getSortieByEtatDuree/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/mouvement/getSortieByTypeDuree/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/mouvement/getSortieByDateDuree/**").hasRole("ADMIN");
		
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/magasin/getMagasinClient/**").hasRole("DEMANDEUR");
		
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/commandeArticle/save/**").hasRole("MAGASINIER");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/commandeArticle/getArticleApprouve/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/commandeArticle/updateQteApprouve/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/commandeArticle/updateQteFournie/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/commandeArticle/getArticleApprouveCmd/**").hasRole("MAGASINIER");
		
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/ArticleMagasin/save/**").hasRole("ADMIN");
		
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/commande/getcommandeparmagasin/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/commande/getcommandeparutilisateur/**").hasRole("MAGASINIER");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/commande/updateEtatCommande/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/commande/getcommandeparmagasinetat/**").hasRole("MAGASINIER");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/commande/getCommandeParMagasinUtilisateurEtat/**").hasRole("MAGASINIER");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/commande/getDemandeparmagasinetat/**").hasRole("MAGASINIER");
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/commande/save/**").hasRole("MAGASINIER");
//		
//		http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/pdf/boncommande").hasRole("MAGASINIER");
//		http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/pdf/bonSortie").hasRole("MAGASINIER");

		http.authorizeRequests().antMatchers(HttpMethod.GET,"/demande/save/**").hasRole("MAGASINIER");
		
		http.authorizeRequests().anyRequest().authenticated(); //tout les ressources de la pp necissiteun authentification
		http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
		http.addFilterBefore(new JWTAuthorizationFilter(),UsernamePasswordAuthenticationFilter.class);
	}
	
		
}
