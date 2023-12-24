package tn.arabsoft.entities;

public class ArticleQuantite {
	
	public Materiel materiel ;
	public int qte ;
	public Materiel getMateriel() {
		return materiel;
	}
	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public ArticleQuantite() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ArticleQuantite(Materiel materiel, int qte) {
		super();
		this.materiel = materiel;
		this.qte = qte;
	}
	@Override
	public String toString() {
		return "CommandeMagasin [materiel=" + materiel + ", qte=" + qte + "]";
	}

 
	
}
