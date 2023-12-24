package tn.arabsoft.Service;


import java.util.List;

import tn.arabsoft.entities.FicheArticle;

public interface FicheArticleIService extends CrudService<FicheArticle> {

	public FicheArticle updateFicheArticleE(int idFA,int qte);
	public FicheArticle updateFicheArticleS(int idFA,int qte);
	public List<FicheArticle> getFicheArticleByMagasinArticle(int idM , int idA);
	public FicheArticle updateStockMinSecAlert(int idFA, int sMin, int sSec,int sAlert);
	public FicheArticle updateStockTheorique(int idFA , int qte);
}
