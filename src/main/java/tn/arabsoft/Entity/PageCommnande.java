package tn.arabsoft.entities;

import java.io.Serializable;
import java.util.List;

public class PageCommnande implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Commande> commandes;
	private int page ;
	private int nbOperations ;
	private int totalOperation;
	private int totalPage ;
	
	public PageCommnande(List<Commande> commandes, int page, int nbOperations, int totalOperation, int totalPage) {
		super();
		this.commandes = commandes;
		this.page = page;
		this.nbOperations = nbOperations;
		this.totalOperation = totalOperation;
		this.totalPage = totalPage;
	}

	public PageCommnande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
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
		return "PageCommnande [commandes=" + commandes + ", page=" + page + ", nbOperations=" + nbOperations
				+ ", totalOperation=" + totalOperation + ", totalPage=" + totalPage + "]";
	}
	
	
	
}
