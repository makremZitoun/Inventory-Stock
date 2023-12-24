package tn.arabsoft.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlSeeAlso;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@Entity
//@Inheritance(strategy=InheritanceType.JOINED)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE",discriminatorType=DiscriminatorType.STRING,length=1)
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="type")
@JsonSubTypes({
	@Type(name="E",value=Entree.class),
	@Type(name="S",value=Sortie.class)
})
@XmlSeeAlso({Entree.class, Sortie.class})

public class MouvementDeStock implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")	
	public int id ;
	
	@Column(name="numero")	
	public int numero ;
	
	@Column(name="referenceMouvement")
	public String referenceMouvement;
	
	@Column(name="observationMouvement")
	public String observationMouvement;
	
	
	@Column(name="dateMouvment")
	public Date dateMouvement = new Date();
	
	@Enumerated(EnumType.STRING)
	public Etat etat ;
	
	
 	@ManyToOne
 	public Utilisateur Utilisateur;
 	
 	@OneToOne
 	public Commande commande ;
 	
 	@OneToOne(cascade = CascadeType.REFRESH)
 	public Document document;

	public MouvementDeStock(int id, int numero, String referenceMouvement, String observationMouvement,
			Date dateMouvement, Etat etat, tn.arabsoft.entities.Utilisateur utilisateur, Commande commande,
			Document document) {
		super();
		this.id = id;
		this.numero = numero;
		this.referenceMouvement = referenceMouvement;
		this.observationMouvement = observationMouvement;
		this.dateMouvement = dateMouvement;
		this.etat = etat;
		Utilisateur = utilisateur;
		this.commande = commande;
		this.document = document;
	}

	public MouvementDeStock() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getReferenceMouvement() {
		return referenceMouvement;
	}

	public void setReferenceMouvement(String referenceMouvement) {
		this.referenceMouvement = referenceMouvement;
	}

	public String getObservationMouvement() {
		return observationMouvement;
	}

	public void setObservationMouvement(String observationMouvement) {
		this.observationMouvement = observationMouvement;
	}

	public Date getDateMouvement() {
		return dateMouvement;
	}

	public void setDateMouvement(Date dateMouvement) {
		this.dateMouvement = dateMouvement;
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public Utilisateur getUtilisateur() {
		return Utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		Utilisateur = utilisateur;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "MouvementDeStock [id=" + id + ", numero=" + numero + ", referenceMouvement=" + referenceMouvement
				+ ", observationMouvement=" + observationMouvement + ", dateMouvement=" + dateMouvement + ", etat="
				+ etat + ", Utilisateur=" + Utilisateur + ", commande=" + commande + ", document=" + document + "]";
	}
 	
	
 	
	
}
