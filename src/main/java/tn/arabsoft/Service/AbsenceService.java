package tn.arabsoft.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.arabsoft.Dao.AbsenceRepository;
import tn.arabsoft.entities.Absence;

@Service
public class AbsenceService implements AbsenceIService {

	@Autowired
	private AbsenceRepository aR;
	@Override
	public Absence save(Absence t) {
		// TODO Auto-generated method stub
		return aR.save(t);
	}

	@Override
	public List<Absence> getAll() {
		// TODO Auto-generated method stub
		return aR.findAll();
	}

	@Override
	public Absence getOne(int id) {
		// TODO Auto-generated method stub
		return aR.findById(id).get();
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		aR.deleteById(id);
		return id;
	}

}
