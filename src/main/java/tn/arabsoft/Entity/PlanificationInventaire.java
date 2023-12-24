package tn.arabsoft.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PlanificationInventaire {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	@Id
	private int id;
	
	@Column(name="dateDebut")
	public Date dateDebut = new Date();
	
	@Column(name="dateFin")
	public Date dateFin = new Date();
	
	
	
	@Column(name="designation")
	public String designation;
	
	@ManyToOne
	@JoinColumn(name="inventaire")
	public Inventaire inventaire;
	
	@ManyToOne
	@JoinColumn(name="utilisateur")
	public Utilisateur utilisateur;
	
//	@ManyToOne
//	@JoinColumn(name="magasin")
//	public Magasin magasin;
		
	public PlanificationInventaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Inventaire getInventaire() {
		return inventaire;
	}

	public void setInventaire(Inventaire inventaire) {
		this.inventaire = inventaire;
	}



	public Utilisateur getUtilisateur() {
		return utilisateur;
	}



	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}



	@Override
	public String toString() {
		return "PlanificationInventaire [id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin
				+ ", designation=" + designation + ", inventaire=" + inventaire + ", utilisateur=" + utilisateur + "]";
	}



	public PlanificationInventaire(int id, Date dateDebut, Date dateFin, String designation, Inventaire inventaire,
			Utilisateur utilisateur) {
		super();
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.designation = designation;
		this.inventaire = inventaire;
		this.utilisateur = utilisateur;
	}

	



	
	
	
	
	
	
}
