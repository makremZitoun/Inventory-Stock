package tn.arabsoft.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SousFamille {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idSC")
	private int id ; 
	
	@Column(name="nomDeSousFamille")
	private String nomDeSousFamille ;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="idc")
	private Famille famille ;
	
	@OneToMany(cascade = CascadeType.ALL ,mappedBy="sousFamille")
	//@Column(name="id_produit")
	private List<Materiel> Materiels ;
	
	
	
	public SousFamille() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SousFamille(int id, String nomDeSousFamille) {
		super();
		this.id = id;
		this.nomDeSousFamille = nomDeSousFamille;
	}
	
	public SousFamille( String nomDeSousFamille) {
		super();
		this.nomDeSousFamille = nomDeSousFamille;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getnomDeSousFamille() {
		return nomDeSousFamille;
	}

	public void setnomDeSousFamille(String nomDeSousFamille) {
		this.nomDeSousFamille = nomDeSousFamille;
	}
	
	public Famille getfamille() {
		return famille;
	}

	public void setfamille(Famille categorie) {
		this.famille = categorie;
	}

	@JsonIgnore
	public List<Materiel> getProduits() {
		return Materiels;
	}

	public void setProduits(List<Materiel> produits) {
		this.Materiels = produits;
	}
	
	
	
}
