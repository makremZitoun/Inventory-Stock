package tn.arabsoft.entities;

import java.util.List;

public class PageMouvementUtilisateur {

	
	private static final long serialVersionUID = 1L;
	private List<MouvementUtilisateur> mouvement;
	private int page ;
	private int nbOperations ;
	private int totalOperation;
	private int totalPage ;
	public PageMouvementUtilisateur(List<MouvementUtilisateur> mouvement, int page, int nbOperations,
			int totalOperation, int totalPage) {
		super();
		this.mouvement = mouvement;
		this.page = page;
		this.nbOperations = nbOperations;
		this.totalOperation = totalOperation;
		this.totalPage = totalPage;
	}
	public PageMouvementUtilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<MouvementUtilisateur> getMouvement() {
		return mouvement;
	}
	public void setMouvement(List<MouvementUtilisateur> mouvement) {
		this.mouvement = mouvement;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNbOperations() {
		return nbOperations;
	}
	public void setNbOperations(int nbOperations) {
		this.nbOperations = nbOperations;
	}
	public int getTotalOperation() {
		return totalOperation;
	}
	public void setTotalOperation(int totalOperation) {
		this.totalOperation = totalOperation;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "PageMouvementUtilisateur [mouvement=" + mouvement + ", page=" + page + ", nbOperations=" + nbOperations
				+ ", totalOperation=" + totalOperation + ", totalPage=" + totalPage + "]";
	}


}
