package tn.arabsoft.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.arabsoft.Dao.EquipeRepository;
import tn.arabsoft.entities.Equipe;

@Service
public class EquipeService implements EquipeIService{
	@Autowired
	private EquipeRepository eR;
	
	@Override
	public Equipe save(Equipe t) {
		// TODO Auto-generated method stub
		return eR.save(t);
	}

	@Override
	public List<Equipe> getAll() {
		// TODO Auto-generated method stub
		return eR.findAll();
	}

	@Override
	public Equipe getOne(int id) {
		// TODO Auto-generated method stub
		return eR.findById(id).get();
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		eR.deleteById(id);
		return id;
	}

//	@Override
//	public List<Equipe> getEquipeDiponible(String dateD) {
//		// TODO Auto-generated method stub
//		return eR.getEquipeDiponible(dateD);
//	}

}
