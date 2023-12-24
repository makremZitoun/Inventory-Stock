package tn.arabsoft.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comptage {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idCmp")
	private int idCmp ; 
	
	@Column(name="qtePhysique")
	private int qtePhysique;
	
	@Column(name="nbComptage")
	private int nbComptage;
	
	@ManyToOne
	@JoinColumn(name="inventaire")
	public Inventaire inventaire ;
	
	@ManyToOne
	@JoinColumn(name="materiel")
	public Materiel materiel ;
	
	@ManyToOne
	public Utilisateur utilisateur;

	public int getIdCmp() {
		return idCmp;
	}

	public void setIdCmp(int idCmp) {
		this.idCmp = idCmp;
	}

	public int getQtePhysique() {
		return qtePhysique;
	}

	public void setQtePhysique(int qtePhysique) {
		this.qtePhysique = qtePhysique;
	}

	public int getNbComptage() {
		return nbComptage;
	}

	public void setNbComptage(int nbComptage) {
		this.nbComptage = nbComptage;
	}

	
	public Inventaire getInventaire() {
		return inventaire;
	}
	
	public void setInventaire(Inventaire inventaire) {
		this.inventaire = inventaire;
	}

	public Materiel getMateriel() {
		return materiel;
	}

	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
	}

	

	public Comptage(int idCmp, int qtePhysique, int nbComptage, Inventaire inventaire, Materiel materiel,
			Utilisateur utilisateur) {
		super();
		this.idCmp = idCmp;
		this.qtePhysique = qtePhysique;
		this.nbComptage = nbComptage;
		this.inventaire = inventaire;
		this.materiel = materiel;
		this.utilisateur = utilisateur;
	}

	public Comptage() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Comptage [idCmp=" + idCmp + ", qtePhysique=" + qtePhysique + ", nbComptage=" + nbComptage
				+ ", inventaire=" + inventaire + ", materiel=" + materiel + ", utilisateur=" + utilisateur + "]";
	}

	

	
	
	
	
	
	
	
}
