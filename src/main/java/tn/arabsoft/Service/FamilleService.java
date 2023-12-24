package tn.arabsoft.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.arabsoft.Dao.FamilleRepository;
import tn.arabsoft.entities.Famille;

@Service
public  class FamilleService implements FamilleIService {

	@Autowired
	private FamilleRepository catR ;
	
	@Override
	public Famille save(Famille t) {
		// TODO Auto-generated method stub
		return catR.save(t);
	}

	@Override
	public List<Famille> getAll() {
		// TODO Auto-generated method stub
		return catR.findAll();
	}

	@Override
	public Famille getOne(int id) {
		// TODO Auto-generated method stub
		return catR.findById(id).get();
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		catR.deleteById(id);
		return id;
	}

	public FamilleService(FamilleRepository cR) {
		super();
		this.catR = cR;
	}

	public FamilleService() {
		super();
	}
	
	

}
