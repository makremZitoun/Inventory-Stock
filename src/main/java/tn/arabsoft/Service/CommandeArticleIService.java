package tn.arabsoft.Service;

import java.util.List;


import tn.arabsoft.entities.ArticleApprouve;
import tn.arabsoft.entities.ArticleQuantite;
import tn.arabsoft.entities.CommandeArticle;
import tn.arabsoft.entities.Etat;

public interface CommandeArticleIService extends CrudService<CommandeArticle> {

	

	public List<ArticleQuantite> getArticleDeCommande(int idC);
	public List<ArticleApprouve> getArticleApprouve(int idC);
	public CommandeArticle updateQteApprouve(int idC , int idA , int qte);
	public CommandeArticle updateQteFournie(int idC , int idA , int qte);
	public List<CommandeArticle> getCommandeArticleByEtat(Etat etatC ,int idC);
	public List<CommandeArticle> getArticleApprouveCmd( int idC);
	
	
}
