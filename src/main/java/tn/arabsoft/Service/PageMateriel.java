package tn.arabsoft.Service;

import java.io.Serializable;
import java.util.List;

import tn.arabsoft.entities.Materiel;


public class PageMateriel implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Materiel> materiel;
	private int page ;
	private int nbOperations ;
	private int totalOperation;
	private int totalPage ;
	public List<Materiel> getmateriel() {
		return materiel;
	}
	public void setmateriel(List<Materiel> materiel) {
		this.materiel = materiel;
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
	@Override
	public String toString() {
		return "Pagemateriel [materiel=" + materiel + ", page=" + page + ", nbOperations=" + nbOperations
				+ ", totalOperation=" + totalOperation + ", totalPage=" + totalPage + "]";
	}
	
	
}
