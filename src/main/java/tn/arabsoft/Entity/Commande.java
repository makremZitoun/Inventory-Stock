package tn.arabsoft.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Commande {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")	
	public int id ;
	
	@Column(name="numero")	
	public int numero ;
	
	@Enumerated(EnumType.STRING)
	public Etat etat;
	
	@Column(name="referenceCommande")
	public String referenceCommande ;
	
	
	@Column(name="typeCommande")
	private String typeCommande;
	
	public Date dateCommande = new Date();

	@ManyToOne
	public Utilisateur utilisateur;
	
	@ManyToOne
	public Magasin magasin;
	
	
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Commande(int id, int numero, Etat etat, String referenceCommande, String typeCommande, Date dateCommande,
			Utilisateur utilisateur, Magasin magasin) {
		super();
		this.id = id;
		this.numero = numero;
		this.etat = etat;
		this.referenceCommande = referenceCommande;
		this.typeCommande = typeCommande;
		this.dateCommande = dateCommande;
		this.utilisateur = utilisateur;
		this.magasin = magasin;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public Etat getEtat() {
		return etat;
	}


	public void setEtat(Etat etat) {
		this.etat = etat;
	}


	public String getReferenceCommande() {
		return referenceCommande;
	}


	public void setReferenceCommande(String referenceCommande) {
		this.referenceCommande = referenceCommande;
	}


	public String getTypeCommande() {
		return typeCommande;
	}


	public void setTypeCommande(String typeCommande) {
		this.typeCommande = typeCommande;
	}


	public Date getDateCommande() {
		return dateCommande;
	}


	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}


	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	public Magasin getMagasin() {
		return magasin;
	}


	public void setMagasin(Magasin magasin) {
		this.magasin = magasin;
	}


	@Override
	public String toString() {
		return "Commande [id=" + id + ", numero=" + numero + ", etat=" + etat + ", referenceCommande="
				+ referenceCommande + ", typeCommande=" + typeCommande + ", dateCommande=" + dateCommande
				+ ", utilisateur=" + utilisateur + ", magasin=" + magasin + "]";
	}
	
	
	

}
