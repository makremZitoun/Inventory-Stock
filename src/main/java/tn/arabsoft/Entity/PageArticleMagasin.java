package tn.arabsoft.entities;

import java.io.Serializable;
import java.util.List;

public class PageArticleMagasin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Materiel> articles;
	private int page ;
	private int nbOperations ;
	private int totalOperation;
	private int totalPage ;


	public PageArticleMagasin() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PageArticleMagasin(List<Materiel> articles, int page, int nbOperations, int totalOperation, int totalPage) {
		super();
		this.articles = articles;
		this.page = page;
		this.nbOperations = nbOperations;
		this.totalOperation = totalOperation;
		this.totalPage = totalPage;
	}



	public List<Materiel> getArticles() {
		return articles;
	}


	public void setArticles(List<Materiel> articles) {
		this.articles = articles;
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
		return "PageArticleMagasin [articles=" + articles + ", page=" + page + ", nbOperations=" + nbOperations
				+ ", totalOperation=" + totalOperation + ", totalPage=" + totalPage + "]";
	}


}
