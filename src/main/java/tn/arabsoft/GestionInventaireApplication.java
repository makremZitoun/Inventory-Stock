package tn.arabsoft;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import tn.arabsoft.Service.CompteIService;


@SpringBootApplication
public class GestionInventaireApplication implements CommandLineRunner{

	@Autowired
	private CompteIService cis ;

	public static void main(String[] args) {
		SpringApplication.run(GestionInventaireApplication.class, args);

	}

	@Bean //cette methode s'execute lors d execution de lapplication
	public BCryptPasswordEncoder getBCEP()
	{return new BCryptPasswordEncoder();}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*	cis.saveU(new Utilisateur("admin","1234"));
		cis.saveU(new Utilisateur("user","1234"));
		cis.saveR(new Role("ADMIN"));	
		cis.saveR(new Role("USER"));*/
//		cis.addRoleToUser("admin","ADMIN");
//		cis.addRoleToUser("admin","USER");
//		cis.addRoleToUser("user","USER");
		System.out.println( cis.findUserByUserName("admin"));
	}

}
