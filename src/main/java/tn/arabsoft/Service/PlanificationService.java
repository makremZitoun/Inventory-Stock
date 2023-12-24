package tn.arabsoft.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.arabsoft.Dao.PlanificationRepository;
import tn.arabsoft.entities.PlanificationInventaire;

@Service
public class PlanificationService implements PlanificationIService {

	@Autowired
	private PlanificationRepository pR;

	@Override
	public PlanificationInventaire save(PlanificationInventaire t) {
		// TODO Auto-generated method stub
		return pR.save(t);
	}

	@Override
	public List<PlanificationInventaire> getAll() {
		// TODO Auto-generated method stub
		return pR.findAll();
	}

	@Override
	public PlanificationInventaire getOne(int id) {
		// TODO Auto-generated method stub
		return pR.findById(id).get();
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		pR.deleteById(id);
		return id;
	}
	
//	@Override
//	public PlanificationInventaire getInventaieEnCours(int idE) {
//		// TODO Auto-generated method stub
//		return pR.getInventaieEnCours(idE);
//	}

}
