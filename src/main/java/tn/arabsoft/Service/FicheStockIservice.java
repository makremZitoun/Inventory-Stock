package tn.arabsoft.Service;


import java.util.List;

import org.springframework.data.repository.query.Param;

import tn.arabsoft.entities.FicheStock;
import tn.arabsoft.entities.PageFicheStock;
import tn.arabsoft.entities.PageMvCmdDelai;

public interface FicheStockIservice extends CrudService<FicheStock> {

	public PageFicheStock findFSbyMouvmemnt(int idM , int page , int size);
	public PageFicheStock getFSByArticle(int id ,int idM ,int page , int size);
	public PageFicheStock getFSByArticleS(int id ,int idM ,int page , int size);
	public PageFicheStock getFSByArticleA(int id ,int idM ,int page , int size);
	public PageMvCmdDelai getMvCmdDelai(int idA,int idM,int page,int size);
	public List<FicheStock> getFSByIntervalle(int idA,int idM,String dateD,String dateF );
	public List<FicheStock> getFicheStockByMouvement(int idMv);

	
	

}
