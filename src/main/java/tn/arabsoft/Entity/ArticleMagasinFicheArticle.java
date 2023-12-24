package tn.arabsoft.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ArticleMagasinFicheArticle {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@Id
	private int id;

	@ManyToOne
	public Materiel materiel;
	
	@ManyToOne
	public Magasin magasin;
	
	@ManyToOne
	public FicheArticle ficheArticle;
   

	public ArticleMagasinFicheArticle() {
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


	public Magasin getMagasin() {
		return magasin;
	}


	public void setMagasin(Magasin magasin) {
		this.magasin = magasin;
	}


	public FicheArticle getFicheArticle() {
		return ficheArticle;
	}


	public void setFicheArticle(FicheArticle ficheArticle) {
		this.ficheArticle = ficheArticle;
	}


	@Override
	public String toString() {
		return "ArticleMagasinFicheArticle [id=" + id + ", materiel=" + materiel + ", magasin=" + magasin
				+ ", ficheArticle=" + ficheArticle + "]";
	}
	
	
	
}
