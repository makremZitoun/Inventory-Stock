package tn.arabsoft.Service;

import java.util.List;

import tn.arabsoft.entities.ArticleMagasinFicheArticle;
import tn.arabsoft.entities.FicheArticle;
import tn.arabsoft.entities.Materiel;
import tn.arabsoft.entities.PageArticleMagasin;

public interface ArticleMagasinFAIService extends CrudService<ArticleMagasinFicheArticle> {

	public FicheArticle getFicheArticle(int idA,int idM);
	public PageArticleMagasin getArticleByMagasin(int idM,int page ,int size);
	public List<Materiel> getArticleByMagasinListe(int idM); 
	public List<Materiel> getArticleByMagasinCategorie(int idM,String nomF);
//	public ArticleMagasinFicheArticle updateFicheArticleE(int idA,int idM ,int q);
//	public ArticleMagasinFicheArticle updateFicheArticleS(int idA,int idM ,int q);
	
}
