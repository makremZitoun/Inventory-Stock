package tn.arabsoft.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Materiel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idP")
	private int id ; 
	
	@Column(name="referenceMateriel")
	private String ref ;
	
	@Column(name="codeABarreMateriel")
	private String codeABarre;
	
	@Column(name="libelleMateriel")
	private String libelle ;
	
	@ManyToOne(cascade={CascadeType.PERSIST})
	private SousFamille sousFamille ;

//	@OneToMany(cascade = CascadeType.ALL, mappedBy="materiel", fetch=FetchType.EAGER)
//	private List<Comptage> listComptage;

	public Materiel() {
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
//	public List<Comptage> getListComptage() {
//		return listComptage;
//	}
//
//	public void setListComptage(List<Comptage> listComptage) {
//		this.listComptage = listComptage;
//	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getCodeABarre() {
		return codeABarre;
	}

	public void setCodeABarre(String codeABarre) {
		this.codeABarre = codeABarre;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public SousFamille getSousFamille() {
		return sousFamille;
	}

	public void setSousFamille(SousFamille sousFamille) {
		this.sousFamille = sousFamille;
	}

	public Materiel(int id, String ref, String codeABarre, String libelle, SousFamille sousFamille) {
		super();
		this.id = id;
		this.ref = ref;
		this.codeABarre = codeABarre;
		this.libelle = libelle;
		this.sousFamille = sousFamille;
	}

	@Override
	public String toString() {
		return "Materiel [id=" + id + ", ref=" + ref + ", codeABarre=" + codeABarre + ", libelle=" + libelle
				+ ", sousFamille=" + sousFamille + "]";
	}

	
	
	
}
