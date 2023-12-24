package tn.arabsoft.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Equipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idE")
	private int id ;
	
	@Column(name="codeEquipe")
	private int codeEquipe;
	
	@Column(name="nomEquipe")
	public String nomEquipe;
	
//    @OneToMany(cascade = CascadeType.ALL,mappedBy="equipe",fetch=FetchType.LAZY)
//    public List<Ressource> listRessource;
//    
//    @OneToMany
//    (cascade = CascadeType.ALL,mappedBy="equipe",fetch=FetchType.LAZY)
//    public List<PlanificationInventaire> listplannifcation;
    
	public Equipe() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	@JsonIgnore
//	public List<PlanificationInventaire> getListplannifcation() {
//		return listplannifcation;
//	}
//
//	public void setListplannifcation(List<PlanificationInventaire> listplannifcation) {
//		this.listplannifcation = listplannifcation;
//	}

	 
	public int getCodeEquipe() {
		return codeEquipe;
	}

	public void setCodeEquipe(int codeEquipe) {
		this.codeEquipe = codeEquipe;
	}

	public Equipe(int id, int codeEquipe, String nomEquipe) {
		super();
		this.id = id;
		this.codeEquipe = codeEquipe;
		this.nomEquipe = nomEquipe;
	}



	@Override
	public String toString() {
		return "Equipe [id=" + id + ", codeEquipe=" + codeEquipe + ", nomEquipe=" + nomEquipe + "]";
	}



	

//	@JsonIgnore
//	public List<Ressource> getListRessource() {
//		return listRessource;
//	}
//
//	public void setListRessource(List<Ressource> listRessource) {
//		this.listRessource = listRessource;
//	}

	 
	

	

	 
	
 
    
}
