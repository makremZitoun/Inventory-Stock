package tn.arabsoft.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FicheArticle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id; 
	
	@Column(name="stockMaximum")
	/*Quantité à ne pas dépasser*/
	private int	stockMaximum;
	
	@Column(name="stockMinimum")
	private int stockMinimum;
	
	@Column(name="stockSecurite")
	private int stockSecurite;
	
	@Column(name="stockAlerte")
	/*Quantite relative à un declenchement D'une Commande*/
	private int stockAlerte;
	
	@Column(name="stockTheorique")
	/*Quantite calculé apres les mouvements(Entree/sortie)*/
	private int stockTheorique;
	
	@Column(name="stockReel")
	/*Quantite calculé apres les inventaires*/
	private int stockReel;
	
	public FicheArticle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FicheArticle(int id, int stockMaximum, int stockMinimum, int stockSécurite, int stockAlerte,
			int stockTheorique, int stockReel, Materiel materiel) {
		super();
		this.id = id;
		this.stockMaximum = stockMaximum;
		this.stockMinimum = stockMinimum;
		this.stockSecurite = stockSécurite;
		this.stockAlerte = stockAlerte;
		this.stockTheorique = stockTheorique;
		this.stockReel = stockReel;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStockMaximum() {
		return stockMaximum;
	}

	public void setStockMaximum(int stockMaximum) {
		this.stockMaximum = stockMaximum;
	}

	public int getStockMinimum() {
		return stockMinimum;
	}

	public void setStockMinimum(int stockMinimum) {
		this.stockMinimum = stockMinimum;
	}

	public int getStockSecurite() {
		return stockSecurite;
	}

	public void setStockSecurite(int stockSécurite) {
		this.stockSecurite = stockSécurite;
	}

	public int getStockAlerte() {
		return stockAlerte;
	}

	public void setStockAlerte(int stockAlerte) {
		this.stockAlerte = stockAlerte;
	}

	public int getStockTheorique() {
		return stockTheorique;
	}

	public void setStockTheorique(int stockTheorique) {
		this.stockTheorique = stockTheorique;
	}

	public int getStockReel() {
		return stockReel;
	}

	public void setStockReel(int stockReel) {
		this.stockReel = stockReel;
	}
   

	@Override
	public String toString() {
		return "FicheArticle [id=" + id + ", stockMaximum=" + stockMaximum + ", stockMinimum=" + stockMinimum
				+ ", stockSecurite=" + stockSecurite + ", stockAlerte=" + stockAlerte + ", stockTheorique="
				+ stockTheorique + ", stockReel=" + stockReel + "]";
	}

	
	
}
