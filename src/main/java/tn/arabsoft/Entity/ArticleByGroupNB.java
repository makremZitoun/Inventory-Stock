package tn.arabsoft.entities;

public class ArticleByGroupNB {
	private String nomFamille;
	private Long nbArticle;
	
	public ArticleByGroupNB( String nomFamille, Long nbArticle) {
		super();
		this.nomFamille = nomFamille;
		this.nbArticle = nbArticle;
	}
	
	@Override
	public String toString() {
		return "ArticleByGroupNB [nomFamille=" + nomFamille + ", nbArticle="
				+ nbArticle + "]";
	}

	
	public String getNomFamille() {
		return nomFamille;
	}

	public void setNomFamille(String nomFamille) {
		this.nomFamille = nomFamille;
	}

	public Long getNbArticle() {
		return nbArticle;
	}

	public void setNbArticle(Long nbArticle) {
		this.nbArticle = nbArticle;
	}
	
	
	
	
	

}
