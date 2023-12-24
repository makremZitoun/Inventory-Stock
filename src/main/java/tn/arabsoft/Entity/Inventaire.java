package tn.arabsoft.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlSeeAlso;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

/**
 * @author Makrem Zitoun
 *
 */
@Entity
//@Inheritance(strategy=InheritanceType.JOINED)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE",discriminatorType=DiscriminatorType.STRING,length=2)
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="type")
@JsonSubTypes({
	@Type(name="IG",value=General.class),
	@Type(name="II",value=Inopine.class)
})
@XmlSeeAlso({General.class,Inopine.class})
public class Inventaire implements Serializable {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idI")
	private int idI ;
	
	@Column(name="numeroInventaire")
	private int numeroInventaire;
	
	@Enumerated(EnumType.STRING)
	private EtatInv etat;
	
	@Column(name="dateInventaire")
	private Date dateInventaire;
	
	@Column(name="dateInventaire1")
	private Date dateInventaire1;
	
	
	@ManyToOne
	@JoinColumn(name="magasin")
	public Magasin magasin;

//	@OneToMany(cascade=CascadeType.ALL, mappedBy="inventaire", fetch=FetchType.LAZY)
//	private List<Document> listSupportInventaire;

	@OneToMany(cascade=CascadeType.ALL, mappedBy="inventaire")
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<Comptage> listComptage;
	
//	@OneToMany(cascade=CascadeType.ALL, mappedBy="inventaire",fetch=FetchType.LAZY)
//	public List<PlanificationInventaire> listPlannification;


	public int getIdI() {
		return idI;
	}

	public void setIdI(int idI) {
		this.idI = idI;
	}
	@JsonIgnore
	public List<Comptage> getListComptage() {
		return listComptage;
	}

	public void setListComptage(List<Comptage> listComptage) {
		this.listComptage = listComptage;
	}
	
	
	
	

//	@JsonIgnore
//	public List<PlanificationInventaire> getListPlannification() {
//		return listPlannification;
//	}
//
//	public void setListPlannification(List<PlanificationInventaire> listPlannification) {
//		this.listPlannification = listPlannification;
//	}

	public Magasin getMagasin() {
		return magasin;
	}

	public void setMagasin(Magasin magasin) {
		this.magasin = magasin;
	}

	public Inventaire() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public List<Document> getListSupportInventaire() {
//		return listSupportInventaire;
//	}
//
//	public void setListSupportInventaire(List<Document> listSupportInventaire) {
//		this.listSupportInventaire = listSupportInventaire;
//	}

	public int getNumeroInventaire() {
		return numeroInventaire;
	}

	public void setNumeroInventaire(int numeroInventaire) {
		this.numeroInventaire = numeroInventaire;
	}

	public EtatInv getEtat() {
		return etat;
	}

	public void setEtat(EtatInv etat) {
		this.etat = etat;
	}

	public Date getDateInventaire() {
		return dateInventaire;
	}

	public void setDateInventaire(Date dateInventaire) {
		this.dateInventaire = dateInventaire;
	}

	
	public Inventaire(int idI, int numeroInventaire, EtatInv etat, Date dateInventaire, Date dateInventaire1,
			Magasin magasin, List<Comptage> listComptage) {
		super();
		this.idI = idI;
		this.numeroInventaire = numeroInventaire;
		this.etat = etat;
		this.dateInventaire = dateInventaire;
		this.dateInventaire1 = dateInventaire1;
		this.magasin = magasin;
		this.listComptage = listComptage;
	}

	public Date getDateInventaire1() {
		return dateInventaire1;
	}

	public void setDateInventaire1(Date dateInventaire1) {
		this.dateInventaire1 = dateInventaire1;
	}

	public Inventaire(int idI, int numeroInventaire, EtatInv etat, Date dateInventaire, Magasin magasin,
			List<Comptage> listComptage) {
		super();
		this.idI = idI;
		this.numeroInventaire = numeroInventaire;
		this.etat = etat;
		this.dateInventaire = dateInventaire;
		this.magasin = magasin;
		this.listComptage = listComptage;
	}

	@Override
	public String toString() {
		return "Inventaire [idI=" + idI + ", numeroInventaire=" + numeroInventaire + ", etat=" + etat
				+ ", dateInventaire=" + dateInventaire + ", magasin=" + magasin + ", listComptage=" + listComptage
				+ "]";
	}

	
	


	

	




}
