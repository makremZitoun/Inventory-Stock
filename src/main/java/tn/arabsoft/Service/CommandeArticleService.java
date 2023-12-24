package tn.arabsoft.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.arabsoft.Dao.CommandeArticleRepository;
import tn.arabsoft.entities.ArticleApprouve;
import tn.arabsoft.entities.ArticleQuantite;
import tn.arabsoft.entities.CommandeArticle;
import tn.arabsoft.entities.Etat;

@Service
public class CommandeArticleService implements CommandeArticleIService{

	@Autowired
	private CommandeArticleRepository caR;
	@Override
	public CommandeArticle save(CommandeArticle t) {
		// TODO Auto-generated method stub
		return caR.save(t);
	}

	@Override
	public List<CommandeArticle> getAll() {
		// TODO Auto-generated method stub
		return caR.findAll();
	}

	@Override
	public CommandeArticle getOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ArticleQuantite> getArticleDeCommande(int idC) {
		// TODO Auto-generated method stub
		return caR.getArticleDeCommande(idC);
	}

	@Override
	public List<ArticleApprouve> getArticleApprouve(int idC) {
		// TODO Auto-generated method stub
		return caR.getArticleApprouve(idC);
	}
	
	@Override
	public CommandeArticle updateQteApprouve(int idC, int idA, int qte) {
	// TODO Auto-generated method stub
	 caR.updateQteApprouve(idC, idA, qte);
	
	 return new CommandeArticle();}
	
	@Override
	public CommandeArticle updateQteFournie(int idC, int idA, int qte) {
		// TODO Auto-generated method stub
		caR.updateQteFournie(idC, idA, qte);
		return new CommandeArticle();
	}
	
	@Override
	public List<CommandeArticle> getCommandeArticleByEtat(Etat etatC, int idC) {
		// TODO Auto-generated method stub
		return caR.getCommandeArticleByEtat(etatC, idC);
	}
	
	@Override
	public List<CommandeArticle> getArticleApprouveCmd(int idC) {
		// TODO Auto-generated method stub
		return caR.getArticleApprouveCmd(idC);
	}
	
}
