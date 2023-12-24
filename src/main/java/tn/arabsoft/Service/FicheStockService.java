package tn.arabsoft.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import tn.arabsoft.Dao.FicheStockRepository;
import tn.arabsoft.entities.FicheStock;
import tn.arabsoft.entities.MvCmdDelai;
import tn.arabsoft.entities.PageFicheStock;
import tn.arabsoft.entities.PageMvCmdDelai;

@Service
public class FicheStockService implements FicheStockIservice {

	@Autowired
	private FicheStockRepository fR;

	@Override
	public FicheStock save(FicheStock t) {
		// TODO Auto-generated method stub
		fR.save(t);
		return t;
	}

	@Override
	public List<FicheStock> getAll() {
		// TODO Auto-generated method stub
		return fR.findAll();
	}

	@Override
	public FicheStock getOne(int id) {
		// TODO Auto-generated method stub
		return fR.findById(id).get();
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		fR.deleteById(id);;
		return id;
	}

	@Override
	public PageFicheStock findFSbyMouvmemnt(int idM , int page , int size) {
		// TODO Auto-generated method stub
		Pageable sortedByReference =  PageRequest.of(page, size);
		Page<FicheStock> ops = fR.findFSbyMouvmemnt(idM,sortedByReference);
    PageFicheStock pFS =  new PageFicheStock();
    pFS.setFicheStock(ops.getContent());
    pFS.setNbOperations(ops.getNumberOfElements());
    pFS.setPage(ops.getNumber());
    pFS.setTotalPage(ops.getTotalPages());
    pFS.setTotalOperation((int)ops.getTotalElements());
		return pFS;
	}
	
	@Override
	public PageFicheStock getFSByArticle(int id, int idM, int page, int size) {
		Pageable sortedByReference =  PageRequest.of(page, size);
		Page<FicheStock> ops = fR.getFSByArticle(id,idM,sortedByReference);
    PageFicheStock pFS =  new PageFicheStock();
    pFS.setFicheStock(ops.getContent());
    pFS.setNbOperations(ops.getNumberOfElements());
    pFS.setPage(ops.getNumber());
    pFS.setTotalPage(ops.getTotalPages());
    pFS.setTotalOperation((int)ops.getTotalElements());
		return pFS;

	}
	
	@Override
	public PageFicheStock getFSByArticleS(int id, int idM, int page, int size) {
		Pageable sortedByReference =  PageRequest.of(page, size);
		Page<FicheStock> ops = fR.getFSByArticleS(id,idM,sortedByReference);
    PageFicheStock pFS =  new PageFicheStock();
    pFS.setFicheStock(ops.getContent());
    pFS.setNbOperations(ops.getNumberOfElements());
    pFS.setPage(ops.getNumber());
    pFS.setTotalPage(ops.getTotalPages());
    pFS.setTotalOperation((int)ops.getTotalElements());
		return pFS;

	}
	
	@Override
	public PageFicheStock getFSByArticleA(int id, int idM, int page, int size) {
		Pageable sortedByReference =  PageRequest.of(page, size);
		Page<FicheStock> ops = fR.getFSByArticleA(id,idM,sortedByReference);
    PageFicheStock pFS =  new PageFicheStock();
    pFS.setFicheStock(ops.getContent());
    pFS.setNbOperations(ops.getNumberOfElements());
    pFS.setPage(ops.getNumber());
    pFS.setTotalPage(ops.getTotalPages());
    pFS.setTotalOperation((int)ops.getTotalElements());
		return pFS;

	}
	
	@Override
	public PageMvCmdDelai getMvCmdDelai(int idA,int idM, int page, int size) {
		
		Pageable sortedByReference =  PageRequest.of(page, size);
		Page<MvCmdDelai> ops = fR.getMvCmdDelai(idA,idM, sortedByReference);
    PageMvCmdDelai pFS =  new PageMvCmdDelai();
    pFS.setMvCmdDelai(ops.getContent());
    pFS.setNbOperations(ops.getNumberOfElements());
    pFS.setPage(ops.getNumber());
    pFS.setTotalPage(ops.getTotalPages());
    pFS.setTotalOperation((int)ops.getTotalElements());
		return pFS;
		
	}

	@Override
	public List<FicheStock> getFSByIntervalle(int idA, int idM,  String dateD, String dateF) {
		return fR.getFSByIntervalle(idA,idM,dateD, dateF);
	}
	
	@Override
	public List<FicheStock> getFicheStockByMouvement(int idMv) {
		// TODO Auto-generated method stub
		return fR.getFicheStockByMouvement(idMv);
	}
}
