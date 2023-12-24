package tn.arabsoft.entities;

import java.util.List;

public class PageFicheStock {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<FicheStock> ficheStock;
	private int page ;
	private int nbOperations ;
	private int totalOperation;
	private int totalPage ;
	public PageFicheStock() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageFicheStock(List<FicheStock> ficheStock, int page, int nbOperations, int totalOperation, int totalPage) {
		super();
		this.ficheStock = ficheStock;
		this.page = page;
		this.nbOperations = nbOperations;
		this.totalOperation = totalOperation;
		this.totalPage = totalPage;
	}
	public List<FicheStock> getFicheStock() {
		return ficheStock;
	}
	public void setFicheStock(List<FicheStock> ficheStock) {
		this.ficheStock = ficheStock;
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
