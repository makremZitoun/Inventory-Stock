package tn.arabsoft.entities;

public class MvGroupByEtat {
	
	private Etat etat ;
	private Long nb ;
	public MvGroupByEtat(Etat etat, Long nb) {
		super();
		this.etat = etat;
		this.nb = nb;
	}
	public MvGroupByEtat() {
		super();
	}
	public Etat getEtat() {
		return etat;
	}
	public void setEtat(Etat etat) {
		this.etat = etat;
	}
	public Long getNb() {
		return nb;
	}
	public void setNb(Long nb) {
		this.nb = nb;
	}
	@Override
	public String toString() {
		return "MvGroupByEtat [etat=" + etat + ", nb=" + nb + "]";
	}
	
	

}
