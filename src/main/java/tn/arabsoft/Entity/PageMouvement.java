package tn.arabsoft.entities;

import java.io.Serializable;
import java.util.List;

public class PageMouvement implements Serializable{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<MouvementDeStock> mouvement;
	private int page ;
	private int nbOperations ;
	private int totalOperation;
	private int totalPage ;
	public PageMouvement(List<MouvementDeStock> mouvement, int page, int nbOperations, int totalOperation,
			int totalPage) {
		super();
		this.mouvement = mouvement;
		this.page = page;
		this.nbOperations = nbOperations;
		this.totalOperation = totalOperation;
		this.totalPage = totalPage;
	}
	public PageMouvement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<MouvementDeStock> getMouvement() {
		return mouvement;
	}
	public void setMouvement(List<MouvementDeStock> mouvement) {
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
	
	
	
}
