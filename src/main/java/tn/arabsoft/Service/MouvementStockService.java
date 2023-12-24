package tn.arabsoft.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import tn.arabsoft.Dao.MouvementRepository;
import tn.arabsoft.entities.Document;
import tn.arabsoft.entities.Etat;
import tn.arabsoft.entities.MouvementDate;
import tn.arabsoft.entities.MouvementDeStock;
import tn.arabsoft.entities.MouvementUtilisateur;
import tn.arabsoft.entities.MvGroupByEtat;
import tn.arabsoft.entities.MvGroupByUserAndEtat;
import tn.arabsoft.entities.PageMouvement;
import tn.arabsoft.entities.PageMouvementUtilisateur;
import tn.arabsoft.entities.PageMouvmentDate;

@Service
public class MouvementStockService implements MouvmentStockIService {

	@Autowired
	private MouvementRepository mR ;
	@Override
	public MouvementDeStock save(MouvementDeStock t) {
		mR.save(t);
		return t;
	}

	@Override
	public List<MouvementDeStock> getAll() {
		// TODO Auto-generated method stub
		return mR.findAll();
	}

	@Override
	public MouvementDeStock getOne(int id) {
		// TODO Auto-generated method stub
		return mR.findById(id).get();
	}

	@Override
	public int delete(int id) {

		mR.deleteById(id);
		return id;
	}

	@Override
	public int getNbMouvement() {
		// TODO Auto-generated method stub
		return mR.getNbMouvement();
	}
	
	@Override
	public int getNbSortie() {
		
		return mR.getNbSortie();
	}

	@Override
	public List<MvGroupByUserAndEtat> getNbMouvmentByUser_Etat() {
		// TODO Auto-generated method stub
		return mR.getNbMouvementByUser_Etat();
	}

	@Override
	public List<MvGroupByEtat> getNBMouvmentByEtat() {
		// TODO Auto-generated method stub
		return mR.getNBMouvmentByEtat();
	}
	
	@Override
	public List<MouvementDeStock> getMouvementByEtat(Etat etatM) {
		// TODO Auto-generated method stub
		return mR.getMouvementByEtat(etatM);
	}

	@Override
	public PageMouvement getPageMouvementByEtat(Etat etatM, int page, int size) {
		// TODO Auto-generated method stub
		Pageable sortedByReference = 
				  PageRequest.of(page, size);
		Page<MouvementDeStock> ops = mR.getPageMouvementByEtat(etatM,sortedByReference);
      PageMouvement pM =  new PageMouvement();
      pM.setMouvement(ops.getContent());
      pM.setNbOperations(ops.getNumberOfElements());
      pM.setPage(ops.getNumber());
      pM.setTotalPage(ops.getTotalPages());
      pM.setTotalOperation((int)ops.getTotalElements());
		return pM;
	}

	@Override
	public PageMouvmentDate getMouvementByEtatDuree(Etat EtatM , int idM,int page, int size) {
	Pageable sortedByReference = 
				  PageRequest.of(page, size);
		Page<MouvementDate> ops = mR.getMouvementByEtatDuree(EtatM,idM,sortedByReference);
    PageMouvmentDate pM =  new PageMouvmentDate();
    pM.setMouvement(ops.getContent());
    pM.setNbOperations(ops.getNumberOfElements());
    pM.setPage(ops.getNumber());
    pM.setTotalPage(ops.getTotalPages());
    pM.setTotalOperation((int)ops.getTotalElements());
		return pM;
	}

	@Override
	public MouvementDeStock updateEtatMouvemnt(Etat etatM, int id) {
		// TODO Auto-generated method stub
		mR.updateEtatMouvemnt(etatM, id);
		
		return new MouvementDeStock();
				
	}
@Override
	public MouvementDeStock updateDocumentMouvemnt(Document d, int id) {
		// TODO Auto-generated method stub
	mR.updateDocumentMouvemnt(d, id);
	return new MouvementDeStock();
	}

	@Override
	public PageMouvementUtilisateur getMouvementByUtilisateur(String username, int page, int size) {
		Pageable sortedByReference = 
				  PageRequest.of(page, size);
		Page<MouvementUtilisateur> ops = mR.getMouvementByUtilisateur(username,sortedByReference);
  PageMouvementUtilisateur pM =  new PageMouvementUtilisateur();
  pM.setMouvement(ops.getContent());
  pM.setNbOperations(ops.getNumberOfElements());
  pM.setPage(ops.getNumber());
  pM.setTotalPage(ops.getTotalPages());
  pM.setTotalOperation((int)ops.getTotalElements());
		return pM;
	}
	
@Override
	public PageMouvmentDate getMouvementByTypeDuree(String typeE,int idM, int page, int size) {
	Pageable sortedByReference = 
			  PageRequest.of(page, size);
	Page<MouvementDate> ops = mR.getMouvementByTypeDuree(typeE, idM,sortedByReference);
PageMouvmentDate pM =  new PageMouvmentDate();
pM.setMouvement(ops.getContent());
pM.setNbOperations(ops.getNumberOfElements());
pM.setPage(ops.getNumber());
pM.setTotalPage(ops.getTotalPages());
pM.setTotalOperation((int)ops.getTotalElements());
	return pM;
	}

@Override
public PageMouvmentDate getMouvementByDateDuree(String dateM, int idM, int page, int size) {
	Pageable sortedByReference = 
			  PageRequest.of(page, size);
	Page<MouvementDate> ops = mR.getMouvementByDateDuree(dateM,idM,sortedByReference);
PageMouvmentDate pM =  new PageMouvmentDate();
pM.setMouvement(ops.getContent());
pM.setNbOperations(ops.getNumberOfElements());
pM.setPage(ops.getNumber());
pM.setTotalPage(ops.getTotalPages());
pM.setTotalOperation((int)ops.getTotalElements());
	return pM;
}

@Override
public PageMouvmentDate getSortieByDateDuree(String dateM, int idM, int page, int size) {
	Pageable sortedByReference = 
			  PageRequest.of(page, size);
	Page<MouvementDate> ops = mR.getSortieByDateDuree(dateM,idM,sortedByReference);
PageMouvmentDate pM =  new PageMouvmentDate();
pM.setMouvement(ops.getContent());
pM.setNbOperations(ops.getNumberOfElements());
pM.setPage(ops.getNumber());
pM.setTotalPage(ops.getTotalPages());
pM.setTotalOperation((int)ops.getTotalElements());
	return pM;
}
@Override
public PageMouvmentDate getSortieByEtatDuree(Etat EtatM, int idM, int page, int size) {
	Pageable sortedByReference = 
			  PageRequest.of(page, size);
	Page<MouvementDate> ops = mR.getSortieByEtatDuree(EtatM,idM,sortedByReference);
PageMouvmentDate pM =  new PageMouvmentDate();
pM.setMouvement(ops.getContent());
pM.setNbOperations(ops.getNumberOfElements());
pM.setPage(ops.getNumber());
pM.setTotalPage(ops.getTotalPages());
pM.setTotalOperation((int)ops.getTotalElements());
	return pM;
}

@Override
public PageMouvmentDate getSortieByTypeDuree(String typeE, int idM, int page, int size) {
	Pageable sortedByReference = 
			  PageRequest.of(page, size);
	Page<MouvementDate> ops = mR.getSortieByTypeDuree(typeE, idM,sortedByReference);
PageMouvmentDate pM =  new PageMouvmentDate();
pM.setMouvement(ops.getContent());
pM.setNbOperations(ops.getNumberOfElements());
pM.setPage(ops.getNumber());
pM.setTotalPage(ops.getTotalPages());
pM.setTotalOperation((int)ops.getTotalElements());
	return pM;
}
}
