package tn.arabsoft.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.arabsoft.Dao.FicheArticleRepository;
import tn.arabsoft.entities.FicheArticle;

@Service
public class FicheArticleService implements FicheArticleIService {

	@Autowired
	private FicheArticleRepository faR;
	
	@Override
	public FicheArticle save(FicheArticle t) {
		// TODO Auto-generated method stub
		faR.save(t);
		return t;
	}

	@Override
	public List<FicheArticle> getAll() {
		// TODO Auto-generated method stub
		return faR.findAll();
	}

	@Override
	public FicheArticle getOne(int id) {
		// TODO Auto-generated method stub
		return faR.findById(id).get();
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		faR.deleteById(id);
		return id;
	}

	@Override
	public FicheArticle updateFicheArticleE(int idFA, int qte) {
		// TODO Auto-generated method stub
	faR.updateFicheArticleE(idFA, qte);
		
	 return faR.findById(idFA).get();
	
	}

	@Override
	public FicheArticle updateFicheArticleS(int idFA, int qte) {
		// TODO Auto-generated method stub
		faR.updateFicheArticleS(idFA,qte);
		
		return faR.findById(idFA).get();
	}
	
	@Override
	public List<FicheArticle> getFicheArticleByMagasinArticle(int idM, int idA) {
		// TODO Auto-generated method stub
		return faR.getFicheArticleByMagasinArticle(idM, idA);
	}
	
	@Override
	public FicheArticle updateStockMinSecAlert(int idFA, int sMin, int sSec, int sAlert) {
		faR.updateStockMinSecAlert(idFA, sMin, sSec, sAlert);
		 return faR.findById(idFA).get();
	}
	
	@Override
	public FicheArticle updateStockTheorique(int idFA, int qte) {
		faR.updateStockTheorique(idFA, qte);
		 return faR.findById(idFA).get();
	}
}
