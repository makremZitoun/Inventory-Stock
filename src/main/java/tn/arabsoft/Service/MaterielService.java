package tn.arabsoft.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.arabsoft.Dao.MaterielRepository;
import tn.arabsoft.entities.Materiel;
import tn.arabsoft.entities.SousFamille;

@Service
public class MaterielService implements MaterielIService{

	@Autowired
	private MaterielRepository pdR ;

	@Override
	public Materiel save(Materiel t) {
		// TODO Auto-generated method stub
		pdR.save(t) ;
		return t;
	}

	@Override
	public List<Materiel> getAll() {
		// TODO Auto-generated method stub
		return pdR.findAll();
	}



	@Override
	public Materiel getOne(int id) {
		// TODO Auto-generated method stub
		return pdR.findById(id).get();
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		pdR.deleteById(id);
		return id;
	}

//	@Override
//	public Materiel findByCB(String code) {
//		// TODO Auto-generated method stub
//		return pdR.findByCodeABarre(code);
//	}
//
	@Override
	public int Updatemateriel(SousFamille sc, int id) {
		// TODO Auto-generated method stub
		 pdR.setCategorie(sc, id);
		 return id ;
	}

	@Override
	public PageMateriel findAll(int idM ,int page, int size) {
		// TODO Auto-generated method stub
		Pageable sortedByReference = 
				  PageRequest.of(page, size);
		Page<Materiel> ops = pdR.findAll(idM,sortedByReference);
        PageMateriel pp =  new PageMateriel();
        pp.setmateriel(ops.getContent());
        pp.setNbOperations(ops.getNumberOfElements());
        pp.setPage(ops.getNumber());
        pp.setTotalPage(ops.getTotalPages());
        pp.setTotalOperation((int)ops.getTotalElements());
		return pp;
	}

	@Override
	public List<Materiel> getArticleByRef(String ref) {
		// TODO Auto-generated method stub
		return this.pdR.getByRef(ref);
	}
//
//	@Override
//	public PageMateriel getArticleDeCommande(int page, int size) {
//		// TODO Auto-generated method stub
//
//		Pageable sortedByReference = 
//				  PageRequest.of(page, size);
//		Page<Materiel> ops = pdR.getArticleDeCommande(sortedByReference);
//      PageMateriel pp =  new PageMateriel();
//      pp.setmateriel(ops.getContent());
//      pp.setNbOperations(ops.getNumberOfElements());
//      pp.setPage(ops.getNumber());
//      pp.setTotalPage(ops.getTotalPages());
//      pp.setTotalOperation((int)ops.getTotalElements());
//		return pp;
//	}
//
	@Override
	public PageMateriel getArticleDeCommandeParMagasin(int idM, int page, int size) {
		Pageable sortedByReference = 
				  PageRequest.of(page, size);
		Page<Materiel> ops = pdR.getArticleDeCommandeParMagasin(idM,sortedByReference);
    PageMateriel pp =  new PageMateriel();
    pp.setmateriel(ops.getContent());
    pp.setNbOperations(ops.getNumberOfElements());
    pp.setPage(ops.getNumber());
    pp.setTotalPage(ops.getTotalPages());
    pp.setTotalOperation((int)ops.getTotalElements());
		return pp;
	}
//
//	@Override
//	public List<Materiel> getArticleParMagasin(int idM , String ref) {
//		// TODO Auto-generated method stub
//		return pdR.getArticleParMagasin(idM,ref);
//	}
// 
//
	
}
