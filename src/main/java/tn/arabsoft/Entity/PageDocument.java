package tn.arabsoft.entities;

import java.io.Serializable;
import java.util.List;

public class PageDocument implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Document> document;
	private int page ;
	private int nbOperations ;
	private int totalOperation;
	private int totalPage ;
	
	
	
	public PageDocument() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageDocument(List<Document> document, int page, int nbOperations, int totalOperation, int totalPage) {
		super();
		this.document = document;
		this.page = page;
		this.nbOperations = nbOperations;
		this.totalOperation = totalOperation;
		this.totalPage = totalPage;
	}
	public List<Document> getDocument() {
		return document;
	}
	public void setDocument(List<Document> document) {
		this.document = document;
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
		return "PageDocument [document=" + document + ", page=" + page + ", nbOperations=" + nbOperations
				+ ", totalOperation=" + totalOperation + ", totalPage=" + totalPage + "]";
	}
	
	

}

