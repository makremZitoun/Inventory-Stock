package tn.arabsoft.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Makrem Zitoun
 *
 */
@Entity
public class Flux {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idF")
	private int idF ; 
	
	@Column(columnDefinition="text")
	private String content;
	
	@Column(name="path")
	private String path;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="utilisateur")
	private Utilisateur utilisateur;
	
	@Column(name="dateChargement")
	private Date datechargement = new Date();
	
	@ManyToOne
	@JoinColumn(name="inventaireID")
	private Inventaire inventaireID;
//	
//	
	public int getIdF() {
		return idF;
	}
	public void setIdF(int idF) {
		this.idF = idF;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	 
	public Date getDatechargement() {
		return datechargement;
	}
	public void setDatechargement(Date datechargement) {
		this.datechargement = datechargement;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Inventaire getInventaireID() {
		return inventaireID;
	}
	public void setInventaireID(Inventaire inventaireID) {
		this.inventaireID = inventaireID;
	}
	public Flux() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Flux(int idF, String content, String path, String name, String description, Utilisateur utilisateur,
			Date datechargement, Inventaire inventaireID) {
		super();
		this.idF = idF;
		this.content = content;
		this.path = path;
		this.name = name;
		this.description = description;
		this.utilisateur = utilisateur;
		this.datechargement = datechargement;
		this.inventaireID = inventaireID;
	}
	@Override
	public String toString() {
		return "Flux [idF=" + idF + ", content=" + content + ", path=" + path + ", name=" + name + ", description="
				+ description + ", utilisateur=" + utilisateur + ", datechargement=" + datechargement
				+ ", inventaireID=" + inventaireID + "]";
	}
	
	
	
	
	
	
	
	
	
}
