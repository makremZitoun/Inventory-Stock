package tn.arabsoft.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idUser")
	private Long id ;
	
	@Column(unique = true)
	private String userName ;
	private String password ; 
	
	@ManyToMany(fetch=FetchType.EAGER )
	private Collection<Role> roles = new ArrayList<>() ;

	@ManyToOne
	private Magasin magasin ;

//	@OneToMany(cascade = CascadeType.ALL,mappedBy="utilisateur")
//	public List<Commande> listCommande ;
//	
//	@OneToMany(cascade = CascadeType.ALL,mappedBy="utilisateur")
//	private List<Ressource> listRessource;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	@JsonIgnore
	public String getPassword() {
		return password;
	}


	@JsonSetter
	public void setPassword(String password) {
		this.password = password;
	} 

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

//	@JsonIgnore
//	public List<Commande> getListCommande() {
//		return listCommande;
//	}
//
//	public void setListCommande(List<Commande> listCommande) {
//		this.listCommande = listCommande;
//	}

	public Utilisateur(Long id, String userName, String password, Equipe equipe, List<Role> roles) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		//		this.equipe = equipe;
		//this.roles = new ArrayList<Role>();
		this.roles = roles;
	}

	public Utilisateur() {
		super();
	}

	public Utilisateur(String userName, String password) {
		// TODO Auto-generated constructor stub
		this.userName = userName;
		this.password = password;
	}

//	
//	@JsonIgnore
//	public List<Ressource> getListRessource() {
//		return listRessource;
//	}
//
//	public void setListRessource(List<Ressource> listRessource) {
//		this.listRessource = listRessource;
//	}

	public Utilisateur(String userName, String password, Collection<Role> roles) {
		super();
		this.userName = userName;
		this.password = password;
		this.roles = roles;
	}

	public Magasin getMagasin() {
		return magasin;
	}

	public void setMagasin(Magasin magasin) {
		this.magasin = magasin;
	}
 
	
	




}
