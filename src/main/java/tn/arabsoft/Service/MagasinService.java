package tn.arabsoft.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.arabsoft.Dao.MagasinRepository;
import tn.arabsoft.entities.Magasin;

@Service
public class MagasinService implements MagasinIService{
	@Autowired
	private MagasinRepository eD ;
	
	@Override
	public Magasin save(Magasin t) {
		// TODO Auto-generated method stub
		return eD.save(t);
	}

	@Override
	public List<Magasin> getAll() {
		// TODO Auto-generated method stub
		return eD.findAll();
	}

	@Override
	public Magasin getOne(int id) {
		// TODO Auto-generated method stub
		return eD.findById(id).get();
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		eD.deleteById(id);
		return id;
	}

	@Override
	public List<Magasin> getMagasinFournisseur() {
		// TODO Auto-generated method stub
		return eD.getMagasinFournisseur();
	}
	
	@Override
	public List<Magasin> getMagasinClient() {
		// TODO Auto-generated method stub
		return eD.getMagasinClient();
	}

	


}
