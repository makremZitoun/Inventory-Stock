package tn.arabsoft.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class FicheStock {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@Id
	private int id;

	@ManyToOne
	@JoinColumn(name = "materiel_id")
	private	Materiel materiel;

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "mouvement_id")
	private	MouvementDeStock mouvmentDeStock;
	
	@Column(name="quantite")
	private int quantite;
	
	private float prixUnite;

	public FicheStock(int id, Materiel materiel, MouvementDeStock mouvmentDeStock,int quantite,
			float prixUnite) {
		super();
		this.id = id;
		this.materiel = materiel;
		this.mouvmentDeStock = mouvmentDeStock;
		this.quantite = quantite;
		this.prixUnite = prixUnite;
	}

	public FicheStock(Materiel materiel, MouvementDeStock mouvmentDeStock, int quantite,
			float prixUnite) {
		super();
		this.materiel = materiel;
		this.mouvmentDeStock = mouvmentDeStock;
		this.quantite = quantite;
		this.prixUnite = prixUnite;
	}

	public FicheStock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Materiel getMateriel() {
		return materiel;
	}

	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
	}

	
	public MouvementDeStock getMouvmentDeStock() {
		return mouvmentDeStock;
	}

	public void setMouvmentDeStock(MouvementDeStock mouvmentDeStock) {
		this.mouvmentDeStock = mouvmentDeStock;
	}

	


	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public float getPrixUnite() {
		return prixUnite;
	}

	public void setPrixUnite(float prixUnite) {
		this.prixUnite = prixUnite;
	}


	
	
}
