package tn.arabsoft.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Magasin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idD")
	private int id ; 
	
	@Column(name="codeMagasin")
	private String codeMagasin;
	
	@Column(name="designationMagasin")
	private String designationMagasin ; 
	
	@Column(name="addressMagasin")
	private String addressMagasin ;
	
	@Column(name="typeMagasin")
	/*Magasin Client ou Magasin Fournisseur*/
	private String typeMagasin ;
			
//	@OneToMany(cascade = CascadeType.ALL,mappedBy="magasin")
//	public List<Utilisateur> listUtilisateur;
//	
//	@OneToMany(cascade=CascadeType.ALL,mappedBy="magasin")
//	public List<PlanificationInventaire> listPLanification;



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getDesignationMagasin() {
		return designationMagasin;
	}



	public void setDesignationMagasin(String designationMagasin) {
		this.designationMagasin = designationMagasin;
	}



	public String getAddressMagasin() {
		return addressMagasin;
	}



	public void setAddressMagasin(String addressMagasin) {
		this.addressMagasin = addressMagasin;
	}



	public String getTypeMagasin() {
		return typeMagasin;
	}



	public void setTypeMagasin(String typeMagasin) {
		this.typeMagasin = typeMagasin;
	}


//	@JsonIgnore
//	public List<Utilisateur> getListUtilisateur() {
//		return listUtilisateur;
//	}
//
//
//
//	public void setListUtilisateur(List<Utilisateur> listUtilisateur) {
//		this.listUtilisateur = listUtilisateur;
//	}

    
	
	public String getCodeMagasin() {
		return codeMagasin;
	}



	public void setCodeMagasin(String codeMagasin) {
		this.codeMagasin = codeMagasin;
	}


//	@JsonIgnore
//	public List<PlanificationInventaire> getListPLanification() {
//		return listPLanification;
//	}
//
//
//
//	public void setListPLanification(List<PlanificationInventaire> listPLanification) {
//		this.listPLanification = listPLanification;
//	}



	public Magasin() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "Magasin [id=" + id + ", codeMagasin=" + codeMagasin + ", designationMagasin=" + designationMagasin
				+ ", addressMagasin=" + addressMagasin + ", typeMagasin=" + typeMagasin + "]";
	}



	public Magasin(int id, String codeMagasin, String designationMagasin, String addressMagasin, String typeMagasin) {
		super();
		this.id = id;
		this.codeMagasin = codeMagasin;
		this.designationMagasin = designationMagasin;
		this.addressMagasin = addressMagasin;
		this.typeMagasin = typeMagasin;
	}



	

	
	

}
