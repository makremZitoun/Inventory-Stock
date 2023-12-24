package tn.arabsoft.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CommandeArticle {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@Id
	private int id;

	@ManyToOne
	public Commande commande;

	@ManyToOne
	public Materiel materiel;
	
	@Column(name="quantiteCommander")
	public int qteCommande;
	
	@Column(name="quantiteApprouve")
	public int qteApprouve;
	
	@Column(name="quantiteFournie")
	public Integer qteFournie;
	
	
	

	public Integer getQteFournie() {
		return qteFournie;
	}

	public void setQteFournie(Integer qteFournie) {
		this.qteFournie = qteFournie;
	}

	public int getQteApprouve() {
		return qteApprouve;
	}

	public void setQteApprouve(int qteApprouve) {
		this.qteApprouve = qteApprouve;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Materiel getMateriel() {
		return materiel;
	}

	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
	}

	public int getQteCommande() {
		return qteCommande;
	}

	public void setQteCommande(int qteCommande) {
		this.qteCommande = qteCommande;
	}

	public CommandeArticle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommandeArticle(int id, Commande commande, Materiel materiel, int qteCommande, int qteApprouve,
			Integer qteFournie) {
		super();
		this.id = id;
		this.commande = commande;
		this.materiel = materiel;
		this.qteCommande = qteCommande;
		this.qteApprouve = qteApprouve;
		this.qteFournie = qteFournie;
	}

	@Override
	public String toString() {
		return "CommandeArticle [id=" + id + ", commande=" + commande + ", materiel=" + materiel + ", qteCommande="
				+ qteCommande + ", qteApprouve=" + qteApprouve + ", qteFournie=" + qteFournie + "]";
	}

	 

	
	
	

}
