package tn.arabsoft.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Famille {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idC")
	private int id ; 

	@Column(name="nomDeFamille")
	private String nomDeFamille ;
	

	@OneToMany(cascade = CascadeType.PERSIST ,mappedBy="famille")
	private List<SousFamille> listDesSousFamille ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getnomDeFamille() {
		return nomDeFamille;
	}

	public void setnomDeFamille(String nomDeFamille) {
		this.nomDeFamille = nomDeFamille;
	}
  @JsonIgnore
	public List<SousFamille> getlistDesSousFamille() {
		return listDesSousFamille ;
	}

	public void setlistDesSousFamille(List<SousFamille> listDesSousCatego) {
		this.listDesSousFamille = listDesSousCatego;
	}

	public Famille(int id, String nomDeFamille, List<SousFamille> listDesSousCatego) {
		super();
		this.id = id;
		this.nomDeFamille = nomDeFamille;
		this.listDesSousFamille = listDesSousCatego;
	}

	public Famille() {
		super();
	}


	
	
	
}
