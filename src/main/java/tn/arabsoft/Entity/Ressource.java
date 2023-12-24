package tn.arabsoft.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Ressource {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idR")
	private int idR ; 

	@ManyToOne
	@JoinColumn(name="equipe")
	public Equipe equipe;
	
	@ManyToOne
	@JoinColumn(name="absence")
	public Absence absence;
		
	@ManyToOne
	@JoinColumn(name="utilisateur")
	public Utilisateur utilisateur;

	public Ressource(int idR, Equipe equipe, Absence absence, Utilisateur utilisateur) {
		super();
		this.idR = idR;
		this.equipe = equipe;
		this.absence = absence;
		this.utilisateur = utilisateur;
	}

	public Ressource() {
		super();
	}

	@Override
	public String toString() {
		return "Ressource [idR=" + idR + ", equipe=" + equipe + ", absence=" + absence + ", utilisateur=" + utilisateur
				+ "]";
	}
	
	
	

}
