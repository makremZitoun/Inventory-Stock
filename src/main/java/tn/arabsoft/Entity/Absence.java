package tn.arabsoft.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Absence {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idAb")
	private int idAb ; 
	
	@Column(name="typeAbsence")
	private int type;
	
	@Column(name="status")
	private int status;
	
	@Column(name="dateDebut")
	private Date dateDebut;
	
	@Column(name="dateFin")
	private Date dateFin;
	
	@Column(name="nbJrs")
	private int nbJrs;
	
	@Column(name="commnetaire")
	private String commentaire;
	 
//	@OneToMany( cascade = CascadeType.ALL,mappedBy="absence")
//	public List<Ressource> listRessource ;

	
	public Absence() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Absence(int idAb, int type, int status, Date dateDebut, Date dateFin, int nbJrs, String commentaire) {
		super();
		this.idAb = idAb;
		this.type = type;
		this.status = status;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.nbJrs = nbJrs;
		this.commentaire = commentaire;
//		this.listRessource = listRessource;
	}

	public int getIdAb() {
		return idAb;
	}

	public void setIdAb(int idAb) {
		this.idAb = idAb;
	}
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public int getNbJrs() {
		return nbJrs;
	}

	public void setNbJrs(int nbJrs) {
		this.nbJrs = nbJrs;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	@Override
	public String toString() {
		return "Absence [idAb=" + idAb + ", type=" + type + ", status=" + status + ", dateDebut=" + dateDebut
				+ ", dateFin=" + dateFin + ", nbJrs=" + nbJrs + ", commentaire=" + commentaire + "]";
	}
 
//
//	public void setListRessource(List<Ressource> listRessource) {
//		this.listRessource = listRessource;
//	}
	
	

 
	
	
	
}
