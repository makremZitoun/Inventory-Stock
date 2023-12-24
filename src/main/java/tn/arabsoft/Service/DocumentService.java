package tn.arabsoft.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import tn.arabsoft.Dao.ImageRepository;
import tn.arabsoft.entities.Document;
import tn.arabsoft.entities.PageDocument;

@Service
public class DocumentService implements DocumentIService{

	@Autowired
	private ImageRepository iR ;

	@Override
	public Optional<Document> findByName(String name) {
		// TODO Auto-generated method stub
		return this.iR.findByName(name);
	}

	@Override
	public Document save(Document t) {
		// TODO Auto-generated method stub
		iR.save(t);
		//		 d = new Document;
		return t;
	}

	@Override
	public List<Document> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document getOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageDocument getBE(int page, int size) {
		Pageable sortedByReference = 
				PageRequest.of(page, size);
		Page<Document> ops = iR.getBE(sortedByReference);
		PageDocument pM =  new PageDocument();
		pM.setDocument(ops.getContent());
		pM.setNbOperations(ops.getNumberOfElements());
		pM.setPage(ops.getNumber());
		pM.setTotalPage(ops.getTotalPages());
		pM.setTotalOperation((int)ops.getTotalElements());
		return pM;
	}

	@Override
	public PageDocument getBS(String nomM,int page, int size) {
		// TODO Auto-generated method stub
		Pageable sortedByReference = 
				PageRequest.of(page, size);
		Page<Document> ops = iR.getBS(nomM,sortedByReference);
		PageDocument pM =  new PageDocument();
		pM.setDocument(ops.getContent());
		pM.setNbOperations(ops.getNumberOfElements());
		pM.setPage(ops.getNumber());
		pM.setTotalPage(ops.getTotalPages());
		pM.setTotalOperation((int)ops.getTotalElements());
		return pM;
	}

	@Override
	public PageDocument getDocumentByDate(String dateD, int page, int size) {
		Pageable sortedByReference = 
				PageRequest.of(page, size);
		Page<Document> ops = iR.getDocumentByDate(dateD,sortedByReference);
		PageDocument pM =  new PageDocument();
		pM.setDocument(ops.getContent());
		pM.setNbOperations(ops.getNumberOfElements());
		pM.setPage(ops.getNumber());
		pM.setTotalPage(ops.getTotalPages());
		pM.setTotalOperation((int)ops.getTotalElements());
		return pM;
	}
	@Override
	public PageDocument getBSByDate(String dateD, int page, int size) {
		Pageable sortedByReference = 
				PageRequest.of(page, size);
		Page<Document> ops = iR.getBSByDate(dateD,sortedByReference);
		PageDocument pM =  new PageDocument();
		pM.setDocument(ops.getContent());
		pM.setNbOperations(ops.getNumberOfElements());
		pM.setPage(ops.getNumber());
		pM.setTotalPage(ops.getTotalPages());
		pM.setTotalOperation((int)ops.getTotalElements());
		return pM;
	}


	@Override
	public int getNbBE() {
		// TODO Auto-generated method stub
		return iR.getNbBE();
	}

	@Override
	public int getNbBS() {
		// TODO Auto-generated method stub
		return iR.getNbBS();
	}
}
