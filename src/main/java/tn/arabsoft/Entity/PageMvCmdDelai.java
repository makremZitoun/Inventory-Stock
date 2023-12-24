package tn.arabsoft.entities;

import java.io.Serializable;
import java.util.List;

public class PageMvCmdDelai implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private List<MvCmdDelai> mvCmdDelai;
	private int page ;
	private int nbOperations ;
	private int totalOperation;
	private int totalPage ;
	
	public PageMvCmdDelai(List<MvCmdDelai> mvCmdDelai, int page, int nbOperations, int totalOperation, int totalPage) {
		super();
		this.mvCmdDelai = mvCmdDelai;
		this.page = page;
		this.nbOperations = nbOperations;
		this.totalOperation = totalOperation;
		this.totalPage = totalPage;
	}

	public PageMvCmdDelai() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<MvCmdDelai> getMvCmdDelai() {
		return mvCmdDelai;
	}

	public void setMvCmdDelai(List<MvCmdDelai> mvCmdDelai) {
		this.mvCmdDelai = mvCmdDelai;
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
		return "PageMvCmdDelai [mvCmdDelai=" + mvCmdDelai + ", page=" + page + ", nbOperations=" + nbOperations
				+ ", totalOperation=" + totalOperation + ", totalPage=" + totalPage + "]";
	}
	
	

}
