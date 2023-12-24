package tn.arabsoft.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import tn.arabsoft.Dao.ArticleMagasinFARepository;
import tn.arabsoft.entities.ArticleMagasinFicheArticle;
import tn.arabsoft.entities.FicheArticle;
import tn.arabsoft.entities.Materiel;
import tn.arabsoft.entities.PageArticleMagasin;

@Service
public class ArticleMagasinFAService implements ArticleMagasinFAIService {
	
	@Autowired
	private ArticleMagasinFARepository amR ;

	@Override
	public ArticleMagasinFicheArticle save(ArticleMagasinFicheArticle t) {
		// TODO Auto-generated method stub
		return amR.save(t);
	}

	@Override
	public List<ArticleMagasinFicheArticle> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleMagasinFicheArticle getOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public FicheArticle getFicheArticle(int idA, int idM) {
		// TODO Auto-generated method stub
		return amR.getFicheArticle(idA, idM);
	}

	@Override
	public PageArticleMagasin getArticleByMagasin(int idM,int page ,int size) {
		// TODO Auto-generated method stub
		Pageable sortedByReference = 
				PageRequest.of(page, size);
		Page<Materiel> ops = amR.getArticleByMagasin(idM,sortedByReference);
		PageArticleMagasin pM = new PageArticleMagasin();
		pM.setArticles(ops.getContent());
		pM.setNbOperations(ops.getNumberOfElements());
		pM.setPage(ops.getNumber());
		pM.setTotalPage(ops.getTotalPages());
		pM.setTotalOperation((int)ops.getTotalElements());
		return pM;
	}
	
	@Override
	public List<Materiel> getArticleByMagasinListe(int idM) {
		// TODO Auto-generated method stub
		return amR.getArticleByMagasinListe(idM);
	}
	
	@Override
	public List<Materiel> getArticleByMagasinCategorie(int idM, String nomF) {
		// TODO Auto-generated method stub
		return amR.getArticleByMagasinCategorie(idM, nomF);
	}

//	@Override
//	public ArticleMagasinFicheArticle updateFicheArticleE(int idA, int idM, int q) {
//		// TODO Auto-generated method stub
//		amR.updateFicheArticleE(idA, idM, q);
//		return new ArticleMagasinFicheArticle();
//	}
//

//	@Override
//	public ArticleMagasinFicheArticle updateFicheArticleS(int idA, int idM, int q) {
//		// TODO Auto-generated method stub
//		amR.updateFicheArticleS(idA, idM, q);
//		return new ArticleMagasinFicheArticle();
//	}

}
