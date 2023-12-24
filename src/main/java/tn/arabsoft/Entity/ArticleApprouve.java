package tn.arabsoft.entities;

public class ArticleApprouve {

	public Materiel materiel ;
	public Long qte ;
	public Materiel getMateriel() {
		return materiel;
	}
	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
	}
	public Long getQte() {
		return qte;
	}
	public void setQte(Long qte) {
		this.qte = qte;
	}
	public ArticleApprouve(Materiel materiel, Long qte) {
		super();
		this.materiel = materiel;
		this.qte = qte;
	}
	public ArticleApprouve() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ArticleApprouve [materiel=" + materiel + ", qte=" + qte + "]";
	}
	
	
}
